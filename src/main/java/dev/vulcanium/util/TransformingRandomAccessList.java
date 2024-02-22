package dev.vulcanium.util;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Function;
import java.util.function.Predicate;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

public final class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess {
    final List<F> fromList;
    final Function<? super F, ? extends T> toFunction;
    final Function<? super T, ? extends F> fromFunction;

    public TransformingRandomAccessList(@NonNull List<F> fromList, @NonNull Function<? super F, ? extends T> toFunction, @NonNull Function<? super T, ? extends F> fromFunction) {
        this.fromList = (List)Preconditions.checkNotNull(fromList);
        this.toFunction = (Function)Preconditions.checkNotNull(toFunction);
        this.fromFunction = (Function)Preconditions.checkNotNull(fromFunction);
    }

    public void clear() {
        this.fromList.clear();
    }

    public T get(int index) {
        return this.toFunction.apply(this.fromList.get(index));
    }

    public @NotNull Iterator<T> iterator() {
        return this.listIterator();
    }

    public @NotNull ListIterator<T> listIterator(int index) {
        return new TransformedListIterator<F, T>(this.fromList.listIterator(index)) {
            T transform(F from) {
                return TransformingRandomAccessList.this.toFunction.apply(from);
            }

            F transformBack(T from) {
                return TransformingRandomAccessList.this.fromFunction.apply(from);
            }
        };
    }

    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    public boolean removeIf(Predicate<? super T> filter) {
        Preconditions.checkNotNull(filter);
        return this.fromList.removeIf((element) -> {
            return filter.test(this.toFunction.apply(element));
        });
    }

    public T remove(int index) {
        return this.toFunction.apply(this.fromList.remove(index));
    }

    public int size() {
        return this.fromList.size();
    }

    public T set(int i, T t) {
        return this.toFunction.apply(this.fromList.set(i, this.fromFunction.apply(t)));
    }

    public void add(int i, T t) {
        this.fromList.add(i, this.fromFunction.apply(t));
    }

    abstract static class TransformedListIterator<F, T> implements ListIterator<T>, Iterator<T> {
        final Iterator<F> backingIterator;

        TransformedListIterator(ListIterator<F> backingIterator) {
            this.backingIterator = (Iterator)Preconditions.checkNotNull(backingIterator);
        }

        private ListIterator<F> backingIterator() {
            return cast(this.backingIterator);
        }

        static <A> ListIterator<A> cast(Iterator<A> iterator) {
            return (ListIterator)iterator;
        }

        public final boolean hasPrevious() {
            return this.backingIterator().hasPrevious();
        }

        public final T previous() {
            return this.transform(this.backingIterator().previous());
        }

        public final int nextIndex() {
            return this.backingIterator().nextIndex();
        }

        public final int previousIndex() {
            return this.backingIterator().previousIndex();
        }

        public void set(T element) {
            this.backingIterator().set(this.transformBack(element));
        }

        public void add(T element) {
            this.backingIterator().add(this.transformBack(element));
        }

        abstract T transform(F var1);

        abstract F transformBack(T var1);

        public final boolean hasNext() {
            return this.backingIterator.hasNext();
        }

        public final T next() {
            return this.transform(this.backingIterator.next());
        }

        public final void remove() {
            this.backingIterator.remove();
        }
    }
}

package dev.vulcanium.plugin.loader.library.impl;

import dev.vulcanium.plugin.loader.library.ClassPathLibrary;
import dev.vulcanium.plugin.loader.library.LibraryLoadingException;
import dev.vulcanium.plugin.loader.library.LibraryStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyFilter;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.resolution.DependencyResult;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transfer.AbstractTransferListener;
import org.eclipse.aether.transfer.TransferCancelledException;
import org.eclipse.aether.transfer.TransferEvent;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenLibraryResolver implements ClassPathLibrary {
    private static final Logger logger = LoggerFactory.getLogger("MavenLibraryResolver");
    private final RepositorySystem repository;
    private final DefaultRepositorySystemSession session;
    private final List<RemoteRepository> repositories = new ArrayList();
    private final List<Dependency> dependencies = new ArrayList();

    public MavenLibraryResolver() {
        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
        locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
        locator.addService(TransporterFactory.class, HttpTransporterFactory.class);
        this.repository = (RepositorySystem)locator.getService(RepositorySystem.class);
        this.session = MavenRepositorySystemUtils.newSession();
        this.session.setSystemProperties(System.getProperties());
        this.session.setChecksumPolicy("fail");
        this.session.setLocalRepositoryManager(this.repository.newLocalRepositoryManager(this.session, new LocalRepository("libraries")));
        this.session.setTransferListener(new AbstractTransferListener() {
            public void transferInitiated(@NotNull TransferEvent event) throws TransferCancelledException {
                Logger var10000 = MavenLibraryResolver.logger;
                String var10002 = event.getResource().getRepositoryUrl();
                var10000.info("Downloading {}", var10002 + event.getResource().getResourceName());
            }
        });
        this.session.setReadOnly();
    }

    public void addDependency(@NotNull Dependency dependency) {
        this.dependencies.add(dependency);
    }

    public void addRepository(@NotNull RemoteRepository remoteRepository) {
        this.repositories.add(remoteRepository);
    }

    public void register(@NotNull LibraryStore store) throws LibraryLoadingException {
        List<RemoteRepository> repos = this.repository.newResolutionRepositories(this.session, this.repositories);

        DependencyResult result;
        try {
            result = this.repository.resolveDependencies(this.session, new DependencyRequest(new CollectRequest((Dependency)null, this.dependencies, repos), (DependencyFilter)null));
        } catch (DependencyResolutionException var7) {
            throw new LibraryLoadingException("Error resolving libraries", var7);
        }

        Iterator var4 = result.getArtifactResults().iterator();

        while(var4.hasNext()) {
            ArtifactResult artifact = (ArtifactResult)var4.next();
            File file = artifact.getArtifact().getFile();
            store.addLibrary(file.toPath());
        }

    }
}

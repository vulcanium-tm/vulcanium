package org.vulcanium.ban;

import org.vulcanium.BanList;

import java.net.InetAddress;

/**
 * A {@link BanList} targeting IP bans.
 */
public interface IpBanList extends BanList<InetAddress> {

}

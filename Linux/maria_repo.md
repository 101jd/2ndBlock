# Установка MySQL (mariadb) на Ubuntu Server

## Установка клиента и сервера с официальных репозиториев Ubuntu

```
root@jd-vm:~# apt install mariadb-
mariadb-backup                          mariadb-plugin-oqgraph
mariadb-client                          mariadb-plugin-rocksdb
mariadb-client-10.6                     mariadb-plugin-s3
mariadb-client-core-10.6                mariadb-plugin-spider
mariadb-common                          mariadb-server
mariadb-plugin-connect                  mariadb-server-10.6
mariadb-plugin-cracklib-password-check  mariadb-server-core-10.6
mariadb-plugin-gssapi-client            mariadb-test
mariadb-plugin-gssapi-server            mariadb-test-data
mariadb-plugin-mroonga               
   
root@jd-vm:~# apt install mariadb-server mariadb-client
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following packages were automatically installed and are no longer required:
  alien at avahi-daemon bsdmainutils colord colord-data cups-bsd cups-client cups-common
  cups-filters cups-filters-core-drivers cups-ipp-utils dconf-gsettings-backend dconf-service
  debhelper debugedit dh-autoreconf dh-strip-nondeterminism dwz fonts-droid-fallback
  fonts-noto-mono ghostscript ipp-usb libarchive-cpio-perl libarchive-zip-perl libavahi-client3
  libavahi-common-data libavahi-common3 libavahi-core7 libcairo2 libcolord2 libcolorhug2 libcups2
  libcupsfilters1 libcupsimage2 libdaemon0 libdconf1 libdebhelper-perl libexif12
  libfile-stripnondeterminism-perl libflashrom1 libfontembed1 libfsverity0 libftdi1-2
  libgphoto2-6 libgphoto2-l10n libgphoto2-port12 libgs9 libgs9-common libieee1284-3 libijs-0.35
  libjbig2dec0 libjpeg62 liblcms2-2 liblouis-data liblouis20 liblouisutdml-bin liblouisutdml-data
  liblouisutdml9 liblua5.3-0 libncurses5 libnss-mdns libopenjp2-7 libpaper-utils libpaper1
  libpixman-1-0 libpoppler-cpp0v5 libpoppler-glib8 libpoppler118 libqpdf28 librpm9 librpmbuild9
  librpmio9 librpmsign9 libsane-common libsane1 libsensors-config libsensors5 libsnmp-base
  libsnmp40 libsub-override-perl libtinfo5 libxcb-render0 libxcb-shm0 libxrender1 lsb-core
  lsb-printing lsb-security ncal pax poppler-data poppler-utils rpm rpm-common rpm2cpio
  sane-airscan sane-utils update-inetd
Use 'apt autoremove' to remove them.
The following additional packages will be installed:
  galera-4 libcgi-fast-perl libcgi-pm-perl libclone-perl libconfig-inifiles-perl
  libdbd-mysql-perl libdbi-perl libencode-locale-perl libfcgi-bin libfcgi-perl libfcgi0ldbl
  libhtml-parser-perl libhtml-tagset-perl libhtml-template-perl libhttp-date-perl
  libhttp-message-perl libio-html-perl liblwp-mediatypes-perl libsnappy1v5 libtimedate-perl
  liburi-perl mariadb-client-10.6 mariadb-client-core-10.6 mariadb-server-10.6
  mariadb-server-core-10.6 socat
Suggested packages:
  libmldbm-perl libnet-daemon-perl libsql-statement-perl libdata-dump-perl
  libipc-sharedcache-perl libbusiness-isbn-perl libwww-perl mariadb-test
The following NEW packages will be installed:
  galera-4 libcgi-fast-perl libcgi-pm-perl libclone-perl libconfig-inifiles-perl
  libdbd-mysql-perl libdbi-perl libencode-locale-perl libfcgi-bin libfcgi-perl libfcgi0ldbl
  libhtml-parser-perl libhtml-tagset-perl libhtml-template-perl libhttp-date-perl
  libhttp-message-perl libio-html-perl liblwp-mediatypes-perl libsnappy1v5 libtimedate-perl
  liburi-perl mariadb-client mariadb-client-10.6 mariadb-client-core-10.6 mariadb-server
  mariadb-server-10.6 mariadb-server-core-10.6 socat
0 upgraded, 28 newly installed, 0 to remove and 6 not upgraded.
Need to get 17.1 MB of archives.
After this operation, 157 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Get:1 http://de.archive.ubuntu.com/ubuntu jammy/universe amd64 galera-4 amd64 26.4.9-1build1 [720 kB]
Get:2 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libdbi-perl amd64 1.643-3build3 [741 kB]
Get:3 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libconfig-inifiles-perl all 3.000003-1 [40.5 kB]
Get:4 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-client-core-10.6 amd64 1:10.6.18-0ubuntu0.22.04.1 [974 kB]
Get:5 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-client-10.6 amd64 1:10.6.18-0ubuntu0.22.04.1 [1,523 kB]
Get:6 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libsnappy1v5 amd64 1.1.8-1build3 [17.5 kB]
Get:7 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-server-core-10.6 amd64 1:10.6.18-0ubuntu0.22.04.1 [7,694 kB]
Get:8 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 socat amd64 1.7.4.1-3ubuntu4 [349 kB]
Get:9 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-server-10.6 amd64 1:10.6.18-0ubuntu0.22.04.1 [4,222 kB]
Get:10 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libhtml-tagset-perl all 3.20-4 [12.5 kB]
Get:11 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 liburi-perl all 5.10-1 [78.8 kB]
Get:12 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libhtml-parser-perl amd64 3.76-1build2 [88.4 kB]
Get:13 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libcgi-pm-perl all 4.54-1 [188 kB]
Get:14 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libfcgi0ldbl amd64 2.4.2-2build2 [28.0 kB]
Get:15 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libfcgi-perl amd64 0.82+ds-1build1 [22.8 kB]
Get:16 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libcgi-fast-perl all 1:2.15-1 [10.5 kB]
Get:17 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libclone-perl amd64 0.45-1build3 [11.0 kB]
Get:18 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 libdbd-mysql-perl amd64 4.050-5ubuntu0.22.04.1 [87.6 kB]
Get:19 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libencode-locale-perl all 1.05-1.1 [11.8 kB]
Get:20 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libfcgi-bin amd64 2.4.2-2build2 [11.2 kB]
Get:21 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libhtml-template-perl all 2.97-1.1 [59.1 kB]
Get:22 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libtimedate-perl all 2.3300-2 [34.0 kB]
Get:23 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libhttp-date-perl all 6.05-1 [9,920 B]
Get:24 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libio-html-perl all 1.004-2 [15.4 kB]
Get:25 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 liblwp-mediatypes-perl all 6.04-1 [19.5 kB]
Get:26 http://de.archive.ubuntu.com/ubuntu jammy/main amd64 libhttp-message-perl all 6.36-1 [76.8 kB]
Get:27 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-client all 1:10.6.18-0ubuntu0.22.04.1 [11.6 kB]
Get:28 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 mariadb-server all 1:10.6.18-0ubuntu0.22.04.1 [11.8 kB]
Fetched 17.1 MB in 0s (39.2 MB/s)          
Preconfiguring packages ...
Selecting previously unselected package galera-4.
(Reading database ... 126931 files and directories currently installed.)
Preparing to unpack .../00-galera-4_26.4.9-1build1_amd64.deb ...
Unpacking galera-4 (26.4.9-1build1) ...
Selecting previously unselected package libdbi-perl:amd64.
Preparing to unpack .../01-libdbi-perl_1.643-3build3_amd64.deb ...
Unpacking libdbi-perl:amd64 (1.643-3build3) ...
Selecting previously unselected package libconfig-inifiles-perl.
Preparing to unpack .../02-libconfig-inifiles-perl_3.000003-1_all.deb ...
Unpacking libconfig-inifiles-perl (3.000003-1) ...
Selecting previously unselected package mariadb-client-core-10.6.
Preparing to unpack .../03-mariadb-client-core-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb ...
Unpacking mariadb-client-core-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Selecting previously unselected package mariadb-client-10.6.
Preparing to unpack .../04-mariadb-client-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb ...
Unpacking mariadb-client-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Selecting previously unselected package libsnappy1v5:amd64.
Preparing to unpack .../05-libsnappy1v5_1.1.8-1build3_amd64.deb ...
Unpacking libsnappy1v5:amd64 (1.1.8-1build3) ...
Selecting previously unselected package mariadb-server-core-10.6.
Preparing to unpack .../06-mariadb-server-core-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb ...
Unpacking mariadb-server-core-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Selecting previously unselected package socat.
Preparing to unpack .../07-socat_1.7.4.1-3ubuntu4_amd64.deb ...
Unpacking socat (1.7.4.1-3ubuntu4) ...
Selecting previously unselected package mariadb-server-10.6.
Preparing to unpack .../08-mariadb-server-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb ...
chfn: PAM: Authentication failure
adduser: `/bin/chfn -f MySQL Server mysql' returned error code 1. Exiting.
dpkg: error processing archive /tmp/apt-dpkg-install-mVMZsC/08-mariadb-server-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb (--unpack):
 new mariadb-server-10.6 package pre-installation script subprocess returned error exit status 1
Selecting previously unselected package libhtml-tagset-perl.
Preparing to unpack .../09-libhtml-tagset-perl_3.20-4_all.deb ...
Unpacking libhtml-tagset-perl (3.20-4) ...
Selecting previously unselected package liburi-perl.
Preparing to unpack .../10-liburi-perl_5.10-1_all.deb ...
Unpacking liburi-perl (5.10-1) ...
Selecting previously unselected package libhtml-parser-perl:amd64.
Preparing to unpack .../11-libhtml-parser-perl_3.76-1build2_amd64.deb ...
Unpacking libhtml-parser-perl:amd64 (3.76-1build2) ...
Selecting previously unselected package libcgi-pm-perl.
Preparing to unpack .../12-libcgi-pm-perl_4.54-1_all.deb ...
Unpacking libcgi-pm-perl (4.54-1) ...
Selecting previously unselected package libfcgi0ldbl:amd64.
Preparing to unpack .../13-libfcgi0ldbl_2.4.2-2build2_amd64.deb ...
Unpacking libfcgi0ldbl:amd64 (2.4.2-2build2) ...
Selecting previously unselected package libfcgi-perl:amd64.
Preparing to unpack .../14-libfcgi-perl_0.82+ds-1build1_amd64.deb ...
Unpacking libfcgi-perl:amd64 (0.82+ds-1build1) ...
Selecting previously unselected package libcgi-fast-perl.
Preparing to unpack .../15-libcgi-fast-perl_1%3a2.15-1_all.deb ...
Unpacking libcgi-fast-perl (1:2.15-1) ...
Selecting previously unselected package libclone-perl.
Preparing to unpack .../16-libclone-perl_0.45-1build3_amd64.deb ...
Unpacking libclone-perl (0.45-1build3) ...
Selecting previously unselected package libdbd-mysql-perl:amd64.
Preparing to unpack .../17-libdbd-mysql-perl_4.050-5ubuntu0.22.04.1_amd64.deb ...
Unpacking libdbd-mysql-perl:amd64 (4.050-5ubuntu0.22.04.1) ...
Selecting previously unselected package libencode-locale-perl.
Preparing to unpack .../18-libencode-locale-perl_1.05-1.1_all.deb ...
Unpacking libencode-locale-perl (1.05-1.1) ...
Selecting previously unselected package libfcgi-bin.
Preparing to unpack .../19-libfcgi-bin_2.4.2-2build2_amd64.deb ...
Unpacking libfcgi-bin (2.4.2-2build2) ...
Selecting previously unselected package libhtml-template-perl.
Preparing to unpack .../20-libhtml-template-perl_2.97-1.1_all.deb ...
Unpacking libhtml-template-perl (2.97-1.1) ...
Selecting previously unselected package libtimedate-perl.
Preparing to unpack .../21-libtimedate-perl_2.3300-2_all.deb ...
Unpacking libtimedate-perl (2.3300-2) ...
Selecting previously unselected package libhttp-date-perl.
Preparing to unpack .../22-libhttp-date-perl_6.05-1_all.deb ...
Unpacking libhttp-date-perl (6.05-1) ...
Selecting previously unselected package libio-html-perl.
Preparing to unpack .../23-libio-html-perl_1.004-2_all.deb ...
Unpacking libio-html-perl (1.004-2) ...
Selecting previously unselected package liblwp-mediatypes-perl.
Preparing to unpack .../24-liblwp-mediatypes-perl_6.04-1_all.deb ...
Unpacking liblwp-mediatypes-perl (6.04-1) ...
Selecting previously unselected package libhttp-message-perl.
Preparing to unpack .../25-libhttp-message-perl_6.36-1_all.deb ...
Unpacking libhttp-message-perl (6.36-1) ...
Selecting previously unselected package mariadb-client.
Preparing to unpack .../26-mariadb-client_1%3a10.6.18-0ubuntu0.22.04.1_all.deb ...
Unpacking mariadb-client (1:10.6.18-0ubuntu0.22.04.1) ...
Selecting previously unselected package mariadb-server.
Preparing to unpack .../27-mariadb-server_1%3a10.6.18-0ubuntu0.22.04.1_all.deb ...
Unpacking mariadb-server (1:10.6.18-0ubuntu0.22.04.1) ...
Errors were encountered while processing:
 /tmp/apt-dpkg-install-mVMZsC/08-mariadb-server-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb
needrestart is being skipped since dpkg has failed
E: Sub-process /usr/bin/dpkg returned an error code (1)

root@jd-vm:~# apt update
Hit:1 https://download.docker.com/linux/ubuntu jammy InRelease
Hit:2 http://de.archive.ubuntu.com/ubuntu jammy InRelease
Get:3 http://de.archive.ubuntu.com/ubuntu jammy-updates InRelease [128 kB]
Hit:4 http://as-repository.openvpn.net/as/debian jammy InRelease
Hit:5 http://de.archive.ubuntu.com/ubuntu jammy-backports InRelease
Get:6 http://de.archive.ubuntu.com/ubuntu jammy-security InRelease [129 kB]
Get:7 http://de.archive.ubuntu.com/ubuntu jammy-updates/main amd64 Packages [2,058 kB]
Get:8 http://de.archive.ubuntu.com/ubuntu jammy-updates/main Translation-en [355 kB]
Get:9 http://de.archive.ubuntu.com/ubuntu jammy-updates/main amd64 c-n-f Metadata [17.8 kB]
Get:10 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 Packages [1,124 kB]
Get:11 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe Translation-en [261 kB]
Get:12 http://de.archive.ubuntu.com/ubuntu jammy-updates/universe amd64 c-n-f Metadata [26.2 kB]
Get:13 http://de.archive.ubuntu.com/ubuntu jammy-security/main amd64 Packages [1,806 kB]
Get:14 http://de.archive.ubuntu.com/ubuntu jammy-security/main Translation-en [295 kB]
Fetched 6,200 kB in 1s (5,294 kB/s)                         
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
8 packages can be upgraded. Run 'apt list --upgradable' to see them.

root@jd-vm:~# apt --fix-broken install 
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
Correcting dependencies... Done
The following packages were automatically installed and are no longer required:
  alien at avahi-daemon bsdmainutils colord colord-data cups-bsd cups-client cups-common
  cups-filters cups-filters-core-drivers cups-ipp-utils dconf-gsettings-backend dconf-service
  debhelper debugedit dh-autoreconf dh-strip-nondeterminism dwz fonts-droid-fallback
  fonts-noto-mono ghostscript ipp-usb libarchive-cpio-perl libarchive-zip-perl libavahi-client3
  libavahi-common-data libavahi-common3 libavahi-core7 libcairo2 libcolord2 libcolorhug2 libcups2
  libcupsfilters1 libcupsimage2 libdaemon0 libdconf1 libdebhelper-perl libexif12
  libfile-stripnondeterminism-perl libflashrom1 libfontembed1 libfsverity0 libftdi1-2
  libgphoto2-6 libgphoto2-l10n libgphoto2-port12 libgs9 libgs9-common libieee1284-3 libijs-0.35
  libjbig2dec0 libjpeg62 liblcms2-2 liblouis-data liblouis20 liblouisutdml-bin liblouisutdml-data
  liblouisutdml9 liblua5.3-0 libncurses5 libnss-mdns libopenjp2-7 libpaper-utils libpaper1
  libpixman-1-0 libpoppler-cpp0v5 libpoppler-glib8 libpoppler118 libqpdf28 librpm9 librpmbuild9
  librpmio9 librpmsign9 libsane-common libsane1 libsensors-config libsensors5 libsnmp-base
  libsnmp40 libsub-override-perl libtinfo5 libxcb-render0 libxcb-shm0 libxrender1 lsb-core
  lsb-printing lsb-security ncal pax poppler-data poppler-utils rpm rpm-common rpm2cpio
  sane-airscan sane-utils update-inetd
Use 'apt autoremove' to remove them.
The following additional packages will be installed:
  mariadb-server-10.6
Suggested packages:
  mariadb-test
The following NEW packages will be installed:
  mariadb-server-10.6
0 upgraded, 1 newly installed, 0 to remove and 8 not upgraded.
27 not fully installed or removed.
Need to get 0 B/4,222 kB of archives.
After this operation, 67.6 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Preconfiguring packages ...
(Reading database ... 127648 files and directories currently installed.)
Preparing to unpack .../mariadb-server-10.6_1%3a10.6.18-0ubuntu0.22.04.1_amd64.deb ...
Unpacking mariadb-server-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up libconfig-inifiles-perl (3.000003-1) ...
Setting up galera-4 (26.4.9-1build1) ...
Setting up libfcgi0ldbl:amd64 (2.4.2-2build2) ...
Setting up libclone-perl (0.45-1build3) ...
Setting up libhtml-tagset-perl (3.20-4) ...
Setting up liblwp-mediatypes-perl (6.04-1) ...
Setting up libfcgi-bin (2.4.2-2build2) ...
Setting up libencode-locale-perl (1.05-1.1) ...
Setting up libsnappy1v5:amd64 (1.1.8-1build3) ...
Setting up mariadb-client-core-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up socat (1.7.4.1-3ubuntu4) ...
Setting up libio-html-perl (1.004-2) ...
Setting up libtimedate-perl (2.3300-2) ...
Setting up libfcgi-perl:amd64 (0.82+ds-1build1) ...
Setting up liburi-perl (5.10-1) ...
Setting up mariadb-client-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up libdbi-perl:amd64 (1.643-3build3) ...
Setting up mariadb-server-core-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up libhttp-date-perl (6.05-1) ...
Setting up mariadb-client (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up mariadb-server-10.6 (1:10.6.18-0ubuntu0.22.04.1) ...
Created symlink /etc/systemd/system/multi-user.target.wants/mariadb.service → /lib/systemd/system/mariadb.service.
Setting up libdbd-mysql-perl:amd64 (4.050-5ubuntu0.22.04.1) ...
Setting up libhtml-parser-perl:amd64 (3.76-1build2) ...
Setting up libhttp-message-perl (6.36-1) ...
Setting up libcgi-pm-perl (4.54-1) ...
Setting up libhtml-template-perl (2.97-1.1) ...
Setting up mariadb-server (1:10.6.18-0ubuntu0.22.04.1) ...
Setting up libcgi-fast-perl (1:2.15-1) ...
Processing triggers for man-db (2.10.2-1) ...
Processing triggers for libc-bin (2.35-0ubuntu3.8) ...
Scanning processes...                                                                              
Scanning candidates...                                                                             
Scanning linux images...                                                                           

Running kernel seems to be up-to-date.

Restarting services...
 systemctl restart packagekit.service
Service restarts being deferred:
 systemctl restart networkd-dispatcher.service
 systemctl restart openvpnas.service
 systemctl restart unattended-upgrades.service

No containers need to be restarted.

No user sessions are running outdated binaries.

No VM guests are running outdated hypervisor (qemu) binaries on this host.
```

## Установка MaxScale со стороннего репозитория

```
root@jd-vm:~# curl -LsS https://r.mariadb.com/downloads/mariadb_repo_setup | bash -s -- --mariadb-maxscale-version="24.02" --os-type=ubuntu --os-version=jammy
# [info] Skipping OS detection and using OS type 'ubuntu' and version 'jammy' as given on the command line
# [info] Checking for script prerequisites.
# [warning] Found existing file at /etc/apt/sources.list.d/mariadb.list. Moving to /etc/apt/sources.list.d/mariadb.list.old_3
# [info] MariaDB Server version 11.rolling is valid
# [info] Repository file successfully written to /etc/apt/sources.list.d/mariadb.list
# [info] Adding trusted package signing keys...
# [info] Running apt-get update...
# [info] Done adding trusted package signing keys
root@jd-vm:~# 
```

## Проверка статуса сервиса

```
root@jd-vm:~# systemctl status mariadb
● mariadb.service - MariaDB 10.6.18 database server
     Loaded: loaded (/lib/systemd/system/mariadb.service; enabled; vendor preset: enabled)
     Active: active (running) since Tue 2024-09-17 13:03:19 CEST; 22min ago
       Docs: man:mariadbd(8)
             https://mariadb.com/kb/en/library/systemd/
    Process: 33940 ExecStartPre=/usr/bin/install -m 755 -o mysql -g root -d /var/run/mysqld (code=>
    Process: 33941 ExecStartPre=/bin/sh -c systemctl unset-environment _WSREP_START_POSITION (code>
    Process: 33943 ExecStartPre=/bin/sh -c [ ! -e /usr/bin/galera_recovery ] && VAR= ||   VAR=`cd >
    Process: 33984 ExecStartPost=/bin/sh -c systemctl unset-environment _WSREP_START_POSITION (cod>
    Process: 33986 ExecStartPost=/etc/mysql/debian-start (code=exited, status=0/SUCCESS)
   Main PID: 33972 (mariadbd)
     Status: "Taking your SQL requests now..."
      Tasks: 8 (limit: 30076)
     Memory: 60.8M
        CPU: 383ms
     CGroup: /system.slice/mariadb.service
             └─33972 /usr/sbin/mariadbd

Sep 17 13:03:19 jd-vm mariadbd[33972]: 2024-09-17 13:03:19 0 [Note] InnoDB: Buffer pool(s) load co>
Sep 17 13:03:19 jd-vm mariadbd[33972]: 2024-09-17 13:03:19 0 [Note] /usr/sbin/mariadbd: ready for >
Sep 17 13:03:19 jd-vm mariadbd[33972]: Version: '10.6.18-MariaDB-0ubuntu0.22.04.1'  socket: '/run/>
Sep 17 13:03:19 jd-vm systemd[1]: Started MariaDB 10.6.18 database server.
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33988]: Upgrading MySQL tables if necessary.
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33991]: Looking for 'mariadb' as: /usr/bin/mariadb
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33991]: Looking for 'mariadb-check' as: /usr/bin/mar>
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33991]: This installation of MariaDB is already upgr>
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33991]: There is no need to run mysql_upgrade again >
Sep 17 13:03:19 jd-vm /etc/mysql/debian-start[33991]: You can use --force if you still want to run>
```

## Проверка работы БД

```
root@jd-vm:~# mysql -u root -p
Enter password: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 40
Server version: 10.6.18-MariaDB-0ubuntu0.22.04.1 Ubuntu 22.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> \h

General information about MariaDB can be found at
http://mariadb.org

List of all client commands:
Note that all text commands must be first on line and end with ';'
?         (\?) Synonym for `help'.
charset   (\C) Switch to another charset. Might be needed for processing binlog with multi-byte charsets.
clear     (\c) Clear the current input statement.
connect   (\r) Reconnect to the server. Optional arguments are db and host.
delimiter (\d) Set statement delimiter.
edit      (\e) Edit command with $EDITOR.
ego       (\G) Send command to MariaDB server, display result vertically.
exit      (\q) Exit mysql. Same as quit.
go        (\g) Send command to MariaDB server.
help      (\h) Display this help.
nopager   (\n) Disable pager, print to stdout.
notee     (\t) Don't write into outfile.
nowarning (\w) Don't show warnings after every statement.
pager     (\P) Set PAGER [to_pager]. Print the query results via PAGER.
print     (\p) Print current command.
prompt    (\R) Change your mysql prompt.
quit      (\q) Quit mysql.
rehash    (\#) Rebuild completion hash.
sandbox   (\-) Disallow commands that access the file system (except \P without an argument and \e).
source    (\.) Execute an SQL script file. Takes a file name as an argument.
status    (\s) Get status information from the server.
system    (\!) Execute a system shell command.
tee       (\T) Set outfile [to_outfile]. Append everything into given outfile.
use       (\u) Use another database. Takes database name as argument.
warnings  (\W) Show warnings after every statement.

For server side help, type 'help contents'

MariaDB [(none)]> CREATE DATABASE test;
Query OK, 1 row affected (0.000 sec)

MariaDB [(none)]> DROP DATABASE test;
Query OK, 0 rows affected (0.026 sec)

MariaDB [(none)]> \q
Bye
root@jd-vm:~# 

```
# EOF

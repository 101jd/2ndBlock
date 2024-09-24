# Работа с утилитой dpkg

## Создание директории для хранения deb-пакетов
```
jd@jd-vm:~$ sudo -i
[sudo] password for jd: 
root@jd-vm:~# mkdir debs/ && cd debs/
```

## Качаем пакет с репозитория
```
root@jd-vm:~/debs# wget http://archive.ubuntu.com/ubuntu/pool/universe/g/gpm/gpm_1.20.7-10build1_amd64.deb
--2024-09-24 19:00:56--  http://archive.ubuntu.com/ubuntu/pool/universe/g/gpm/gpm_1.20.7-10build1_amd64.deb
Resolving archive.ubuntu.com (archive.ubuntu.com)... 91.189.91.82, 185.125.190.83, 91.189.91.83, ...
Connecting to archive.ubuntu.com (archive.ubuntu.com)|91.189.91.82|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 185510 (181K) [application/vnd.debian.binary-package]
Saving to: ‘gpm_1.20.7-10build1_amd64.deb’

gpm_1.20.7-10build1_amd64.deb                     100%[============================================================================================================>] 181.16K   480KB/s    in 0.4s    

2024-09-24 19:00:57 (480 KB/s) - ‘gpm_1.20.7-10build1_amd64.deb’ saved [185510/185510]
```
## Устанавливаем пакет
### (gpm позволяет отображать курсор в VM-console, таких как консоль ProxMox, например)
```
root@jd-vm:~/debs# dpkg -i gpm_1.20.7-10build1_amd64.deb 
Selecting previously unselected package gpm.
(Reading database ... 128465 files and directories currently installed.)
Preparing to unpack gpm_1.20.7-10build1_amd64.deb ...
Unpacking gpm (1.20.7-10build1) ...
Setting up gpm (1.20.7-10build1) ...

Creating config file /etc/gpm.conf with new version
Created symlink /etc/systemd/system/multi-user.target.wants/gpm.service → /lib/systemd/system/gpm.service.
Processing triggers for install-info (6.8-4build1) ...
Processing triggers for man-db (2.10.2-1) ...
```

## Проверяем... <br>И останавливаем перед удалением
```
root@jd-vm:~/debs# gpm
root@jd-vm:~/debs# systemctl stop gpm.service 
```

## Удаление
```
root@jd-vm:~/debs# dpkg -r gpm
(Reading database ... 128505 files and directories currently installed.)
Removing gpm (1.20.7-10build1) ...
Processing triggers for man-db (2.10.2-1) ...
Processing triggers for install-info (6.8-4build1) ...
```
## Проверка

```
root@jd-vm:~/debs# gpm
-bash: /usr/sbin/gpm: No such file or directory
```

# EOF
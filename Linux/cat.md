# Добмашняя работа по командам Linux
## Создание и объединение файлов с помощью команды cat
```
jd@jd-vm:~$ mkdir 2ndBlock/
jd@jd-vm:~$ cd 2ndBlock/
jd@jd-vm:~/2ndBlock$ cat > pets
dogs
cats
humsters
jd@jd-vm:~$ 
jd@jd-vm:~$ 
jd@jd-vm:~/2ndBlock$ cat > pack_animals
horses
donkeys
camels
jd@jd-vm:~$ 
jd@jd-vm:~$ 
jd@jd-vm:~/2ndBlock$ cat pets pack_animals > human_friends
jd@jd-vm:~/2ndBlock$ cat human_friends 
dogs
cats
humsters
horses
donkeys
camels
jd@jd-vm:~$ 
jd@jd-vm:~$ 
jd@jd-vm:~/2ndBlock$ ls
human_friends  pack_animals  pets
```
## Создание директории и перемещение в неё файла
```
jd@jd-vm:~/2ndBlock$ mkdir animaldir/
jd@jd-vm:~/2ndBlock$ mv human_friends animaldir/
jd@jd-vm:~/2ndBlock$ cd animaldir/ && ls
human_friends
jd@jd-vm:~/2ndBlock/animaldir$ 
```

# EOF
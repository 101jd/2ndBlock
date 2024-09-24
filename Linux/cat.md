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
Символ __'>'__ это поток ввода данных. Для дозаписи в файл необходимо использовать __'>>'__. Символ вывода данных __'<'__ подставляется в команде __cat__ автоматически.
## Создание директории и перемещение в неё файла
```
jd@jd-vm:~/2ndBlock$ mkdir animaldir/
jd@jd-vm:~/2ndBlock$ mv human_friends animaldir/
jd@jd-vm:~/2ndBlock$ cd animaldir/ && ls
human_friends
jd@jd-vm:~/2ndBlock/animaldir$ 
```
* Команда __'mv'__ способна как переносить файлы и папки со всем содержимым внутри файловой системы, так и переименовывать их.
* Логическая операция __bash__ __'&&'__ это логическое _'AND'_. Если команды разделены этим логическим оператором, следующая команда выполняется в случае успешного выполнения предыдущей. Если стоит операция __'||'__ _'OR'_ то следующая команда выполняется в том случае, если предыдущая завершилась с экзит-кодом, отличным от нуля.

# EOF
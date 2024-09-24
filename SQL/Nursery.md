# Работа с таблицами MySQL


## Заходим в mariadb под рутом

```
jd@jd-vm:~$ mysql -u root -p
Enter password: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 49
Server version: 10.6.18-MariaDB-0ubuntu0.22.04.1 Ubuntu 22.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
```

## Создаём новую базу данных и подключаемся к ней

```
MariaDB [(none)]> CREATE DATABASE HumanFriends
    -> ;
Query OK, 1 row affected (0.000 sec)

MariaDB [(none)]> USE HumanFriends;
Database changed
```

## Создаём таблицы

```
MariaDB [HumanFriends]> CREATE TABLE AnimalTypes (
    ->  id INT AUTO_INCREMENT PRIMARY KEY,
    ->  animal_type VARCHAR(10)
    -> );
Query OK, 0 rows affected (0.052 sec)

MariaDB [HumanFriends]> CREATE TABLE Animals (
    ->  id INT AUTO_INCREMENT PRIMARY KEY,
    ->  id_type INT,
    ->  name VARCHAR(50),
    ->  birthday DATE,
    ->  FOREIGN KEY (id_type) REFERENCES AnimalTypes (id)
    -> );
Query OK, 0 rows affected (0.004 sec)

MariaDB [HumanFriends]> CREATE TABLE Commands (
    ->  id INT AUTO_INCREMENT PRIMARY KEY,
    ->  animal_id INT,
    ->  command VARCHAR(100),
    ->  FOREIGN KEY (animal_id) REFERENCES Animals (id)
    -> );
Query OK, 0 rows affected (0.012 sec)
```

## Заполняем таблицы данными

```
MariaDB [HumanFriends]> INSERT INTO AnimalTypes (animal_type) 
    -> VALUES ("CAT"),
    -> ("DOG"),
    -> ("HUMSTER"),
    -> ("HORSE"),
    -> ("DONKEY"),
    -> ("CAMEL");
Query OK, 6 rows affected (0.001 sec)
Records: 6  Duplicates: 0  Warnings: 0


MariaDB [HumanFriends]> INSERT INTO Animals (id_type, name, birthday) VALUES (1, "Meow", "1999-04-12"), (2, "Bark", "2000-05-19"), (3, "Cov", "2020-01-01"), (4, "Rarity", "2007-05-01),05-01"), (5, "Donkey", "1987-11-10"), (6, "Ahmed", "1990-04-12"), (1, "Whiskers", "2017-06-06"), (2, "Rex", "1990-12-31"), (3, "Puff", "2024-09-24"), (4, "Fluttershy", "1986-04-26)26") , (5, "Zharov", "1964-08-11"), (6, "Yashka", "2000-10-10");
Query OK, 12 rows affected (0.001 sec)
Records: 12  Duplicates: 0  Warnings: 0

MariaDB [HumanFriends]> SELECT a.id, a.name, a.birthday, at.animal_type 
    -> FROM Animals a
    -> JOIN AnimalTypes at ON a.id_type = at.id;
+----+------------+------------+-------------+
| id | name       | birthday   | animal_type |
+----+------------+------------+-------------+
|  1 | Meow       | 1999-04-12 | CAT         |
|  7 | Whiskers   | 2017-06-06 | CAT         |
|  2 | Bark       | 2000-05-19 | DOG         |
|  8 | Rex        | 1990-12-31 | DOG         |
|  3 | Cov        | 2020-01-01 | HUMSTER     |
|  9 | Puff       | 2024-09-24 | HUMSTER     |
|  4 | Rarity     | 2007-05-01 | HORSE       |
| 10 | Fluttershy | 1986-04-26 | HORSE       |
|  5 | Donkey     | 1987-11-10 | DONKEY      |
| 11 | Zharov     | 1964-08-11 | DONKEY      |
|  6 | Ahmed      | 1990-04-12 | CAMEL       |
| 12 | Yashka     | 2000-10-10 | CAMEL       |
+----+------------+------------+-------------+
12 rows in set (0.000 sec)
```

## Пересоздание таблиц и установление связей между ними
```
MariaDB [HumanFriends]> DROP TABLE Commands;
Query OK, 0 rows affected (0.010 sec)


MariaDB [HumanFriends]> CREATE TABLE CommandTypes (
    ->  id INT AUTO_INCREMENT PRIMARY KEY,
    ->  command VARCHAR(100)
    -> );
Query OK, 0 rows affected (0.008 sec)

MariaDB [HumanFriends]> CREATE TABLE Commands (
    ->  id INT AUTO_INCREMENT PRIMARY KEY,
    ->  animal_id INT,
    ->  command_id INT,
    ->  FOREIGN KEY (animal_id) REFERENCES Animals (id),
    ->  FOREIGN KEY (command_id) REFERENCES CommandTypes(id)
    -> );
Query OK, 0 rows affected (0.005 sec)

MariaDB [HumanFriends]> INSERT INTO CommandTypes (command) VALUES
    -> ("sit"),
    -> ("lay"),
    -> ("voice"),
    -> ("highfive");
Query OK, 4 rows affected (0.001 sec)
Records: 4  Duplicates: 0  Warnings: 0

MariaDB [HumanFriends]> INSERT INTO Commands (animal_id, command_id) VALUES
    -> (1, 1),
    -> (1, 2),
    -> (7, 2),
    -> (7, 3),
    -> (2, 1),
    -> (2, 4),
    -> (2, 3),
    -> (8, 1),
    -> (8, 2),
    -> (8, 4),
    -> (4, 1),
    -> (10, 2),
    -> (11, 3),
    -> (6, 1),
    -> (12, 2);
Query OK, 15 rows affected (0.001 sec)
Records: 15  Duplicates: 0  Warnings: 0
```
## Объединение всех таблиц в одну
```
MariaDB [HumanFriends]> SELECT a.id, a.name, a.birthday, at.animal_type, ct.command FROM
    -> Animals a
    -> JOIN AnimalTypes at ON at.id = a.id_type
    -> JOIN Commands c ON c.animal_id = a.id
    -> JOIN CommandTypes ct ON ct.id = c.command_id
    -> ORDER BY a.id;
+----+------------+------------+-------------+----------+
| id | name       | birthday   | animal_type | command  |
+----+------------+------------+-------------+----------+
|  1 | Meow       | 1999-04-12 | CAT         | lay      |
|  1 | Meow       | 1999-04-12 | CAT         | sit      |
|  2 | Bark       | 2000-05-19 | DOG         | highfive |
|  2 | Bark       | 2000-05-19 | DOG         | sit      |
|  2 | Bark       | 2000-05-19 | DOG         | voice    |
|  4 | Rarity     | 2007-05-01 | HORSE       | sit      |
|  6 | Ahmed      | 1990-04-12 | CAMEL       | sit      |
|  7 | Whiskers   | 2017-06-06 | CAT         | lay      |
|  7 | Whiskers   | 2017-06-06 | CAT         | voice    |
|  8 | Rex        | 1990-12-31 | DOG         | highfive |
|  8 | Rex        | 1990-12-31 | DOG         | lay      |
|  8 | Rex        | 1990-12-31 | DOG         | sit      |
| 10 | Fluttershy | 1986-04-26 | HORSE       | lay      |
| 11 | Zharov     | 1964-08-11 | DONKEY      | voice    |
| 12 | Yashka     | 2000-10-10 | CAMEL       | lay      |
+----+------------+------------+-------------+----------+
15 rows in set (0.001 sec)
```
## Вычисление возраста животных и вывод только молодых животных
```
MariaDB [HumanFriends]> SELECT id, name, DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birthday)), '%Y') + 0 AS age FROM Animals;
+----+------------+------+
| id | name       | age  |
+----+------------+------+
|  1 | Meow       |   25 |
|  2 | Bark       |   24 |
|  3 | Cov        |    4 |
|  4 | Rarity     |   17 |
|  5 | Donkey     |   36 |
|  6 | Ahmed      |   34 |
|  7 | Whiskers   |    7 |
|  8 | Rex        |   33 |
|  9 | Puff       |    0 |
| 10 | Fluttershy |   38 |
| 11 | Zharov     |   60 |
| 12 | Yashka     |   23 |
+----+------------+------+
12 rows in set (0.000 sec)

MariaDB [HumanFriends]> SELECT id, name, DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birthday)), '%Y') + 0 AS Age FROM Animals
    -> WHERE Age BETWEEN 1 AND 11;
ERROR 1054 (42S22): Unknown column 'Age' in 'where clause'
MariaDB [HumanFriends]> SELECT id, name, DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birthday)), '%Y') + 0 AS Age FROM Animals WHERE DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),birthday)), '%Y') + 0 BETWEEN 1 AND11;
+----+----------+------+
| id | name     | Age  |
+----+----------+------+
|  3 | Cov      |    4 |
|  7 | Whiskers |    7 |
+----+----------+------+
2 rows in set (0.000 sec)
```
## Таблица, где имеются только ослы и лошади
```
MariaDB [HumanFriends]> SELECT * FROM Animals JOIN AnimalTypes ON AnimalTypes.id = Animals.id_type WHERE animal_type = "DONKEY" OR animal_type = "HORSE";
+----+---------+------------+------------+----+-------------+
| id | id_type | name       | birthday   | id | animal_type |
+----+---------+------------+------------+----+-------------+
|  4 |       4 | Rarity     | 2007-05-01 |  4 | HORSE       |
| 10 |       4 | Fluttershy | 1986-04-26 |  4 | HORSE       |
|  5 |       5 | Donkey     | 1987-11-10 |  5 | DONKEY      |
| 11 |       5 | Zharov     | 1964-08-11 |  5 | DONKEY      |
+----+---------+------------+------------+----+-------------+
4 rows in set (0.000 sec)
```

# EOF
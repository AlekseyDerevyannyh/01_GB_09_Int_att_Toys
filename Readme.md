# Промежуточная аттестация
* **
### Автор проекта:
Деревянных Алексей
* **
## *Linux*
* **
1. Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»
````
db@ubuntugb:~/gb$ mkdir "Игрушки для школьников" "Игрушки для дошколят"
````
2. Создайте в директории «Игрушки для школьников» текстовые
   файлы - «Роботы», «Конструктор», «Настольные игры»
````
db@ubuntugb:~/gb$ cd "Игрушки для школьников"
db@ubuntugb:~/gb/Игрушки для школьников$ touch "Роботы" "Конструктор" "Настольные игры"
````
3. Создайте в директории «Игрушки для дошколят» текстовые
   файлы «Мягкие игрушки», «Куклы», «Машинки»
````
db@ubuntugb:~/gb/Игрушки для школьников$ cd ../"Игрушки для дошколят"
db@ubuntugb:~/gb/Игрушки для дошколят$ touch "Мягкие игрушки" "Куклы" "Машинки"
````
4. Объединить 2 директории в одну «Имя Игрушки»
````
db@ubuntugb:~/gb/Игрушки для дошколят$ cd ..
db@ubuntugb:~/gb$ mv "Игрушки для дошколят" "Имя Игрушки"
db@ubuntugb:~/gb$ mv "Игрушки для школьников"/* "Имя Игрушки"
db@ubuntugb:~/gb$ rm -r "Игрушки для школьников"
````
5. Переименовать директорию «Имя Игрушки» в «Игрушки»
````
db@ubuntugb:~/gb$ mv "Имя Игрушки" "Игрушки"
````
6. Просмотреть содержимое каталога «Игрушки».
````
db@ubuntugb:~/gb$ ls -la "Игрушки"
total 8
drwxrwxr-x 2 db db 4096 Feb 19 21:47  .
drwxrwxr-x 3 db db 4096 Feb 19 21:49  ..
-rw-rw-r-- 1 db db    0 Feb 19 18:45  Конструктор
-rw-rw-r-- 1 db db    0 Feb 19 21:31  Куклы
-rw-rw-r-- 1 db db    0 Feb 19 21:31  Машинки
-rw-rw-r-- 1 db db    0 Feb 19 21:31 'Мягкие игрушки'
-rw-rw-r-- 1 db db    0 Feb 19 18:45 'Настольные игры'
-rw-rw-r-- 1 db db    0 Feb 19 18:45  Роботы
db@ubuntugb:~/gb$
````
7.Установить и удалить snap-пакет. (Любой, какой хотите)
````
db@ubuntugb:~/gb$ snap search whatsapp
Name                       Version          Publisher        Notes  Summary
whatsapp-app               1.0.1            foksord          -      WhatsApp App
whatsapp-for-linux         1.6.0            nshecan          -      An unofficial WhatsApp desktop application for Linux
whatsapp-4linux            1.1.0            chimekkoo        -      WhatsApp unofficial desktop app for linux
opera                      95.0.4635.46     opera-software✓  -      Fast, secure, easy-to-use browser
ultimate-media-downloader  4.4              keshavnrj✪       -      Online video & audio downloader for Linux, 1300+ websites support
whatsdesk                  0.3.8            zerkc            -      whatsdesk
opera-beta                 96.0.4693.16     opera-software✓  -      Fast and secure web browser
opera-developer            97.0.4704.0      opera-software✓  -      Fast and secure web browser
whatsie                    v4.12.1.fa5add0  keshavnrj✪       -      Feature rich WhatsApp Client for Linux Desktop
kesty-whatsapp             1.2.6            olubunmi708      -      kesty-whatsapp
walc                       0.2.1            cstayyab         -      WALC - unofficial WhatsApp Linux Client
wrapup                     0.1.3            validatedev      -      A Whatsapp client for Linux
whatee                     1.0.0            heliherreradev   -      A simple unofficial WhatsApp desktop client.
singlebox                  29.0.2           webcatalog       -      All-in-One Messenger
cantara                    2.4.1            archchem         -      A Song Presentation Software
ferdi                      5.8.1            getferdi         -      Ferdi
txtme                      2.2.1            txtme            -      txt.me - Customer Service Live Chat
db@ubuntugb:~/gb$ sudo snap install whatsapp-app
whatsapp-app 1.0.1 from Fatih YOLCU (foksord) installed
db@ubuntugb:~/gb$ sudo snap remove whatsapp-app
whatsapp-app removed
db@ubuntugb:~/gb$
````
8. Добавить произвольную задачу для выполнения каждые 3
   минуты (Например, запись в текстовый файл чего-то или
   копирование из каталога А в каталог Б).
````
db@ubuntugb:~$ crontab -e
no crontab for db - using an empty one

Select an editor.  To change later, run 'select-editor'.
1. /bin/nano        <---- easiest
2. /usr/bin/mcedit
3. /usr/bin/vim.tiny
4. /bin/ed

Choose 1-4 [1]: 1
crontab: installing new crontab
db@ubuntugb:~$ crontab -l | grep -v ^#
*/3 * * * * cp -R ~/gb ~/gb_backup
````
* **
## *Приложение магазин игрушек (Java)*
* **

### Описание
Консольное приложение **Магазин игрушек** содержит функционал для розыгрыша игрушек. Список игрушек, участвующих в розыгрыше содержится в файле _**toys.csv**_. Розыгранные игрушки записываются в файл _**out.txt**_. В программе реализованы следующие функции:
* просмотр списка игрушек, участвующих в розыгрыше
* просмотр информации по конкретной игрушке
* добавление/изменение/удаление игрушек 
* розыгрыш игрушки и добавление её в файл _**out.txt**_
* проведение 10-ти розыгрышей подряд и запись информации в файл _**out.txt**_
* очистка файла _**out.txt**_

Запуск приложения осуществляется через файл _**toys/src/Main.java**_

### Управление приложением
Управление приложением осуществляется посредством ввода команд.

Список команд:
* **Help** - вывод справки по доступным командам
* **List** - вывод списка всех игрушек
* **Read** - вывод информации об игрушке по id
* **Put** - добавление новой игрушки
* **Edit** - редактирование информации об игрушке по id
* **Delete** - удаление игрушки по id
* **Get** - проведение розыгрыша одной игрушки и запись информации в файл _**out.txt**_
* **Get10** - проведение розыгрыша 10-ти игрушек и запись информации в файл _**out.txt**_
* **Clear** - очистка файла _**out.txt**_
* **Exit** - выход из программы
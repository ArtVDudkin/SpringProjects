# `Домашнее задание 1`

## `Задача:`
1. Установить себе maven или gradle (если еще не установлено) PS удобно использовать sdkman https://sdkman.io/  
2. С помощью сборщика сгенерировать проект.  
3. Выполнить команду по выполнению сборки.  
4. Сделать скриншот результатов сборки и прислать в качестве ДЗ.  


## `Полезные команды (для Maven-проекта):`
1. Сгенерировать проект `mvn archetype:generate "-DgroupId=com.mycompany.app" "-DartifactId=myProject" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"`  
2. Выполнить сборку проекта `mvn package`. В результате создается папка target, в которой есть файл myProject-1.0-SNAPSHOT.jar  
3. Запускаем программу (jar-файл) на исполнение, указывая путь к классу main внутри src `java -cp .\target\myProject-1.0-SNAPSHOT.jar com.mycompany.app.App`
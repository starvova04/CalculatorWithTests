Калькулятор

Опис:
Це Maven-проєкт, що складається з трьох модулів:

calc-api: Містить інтерфейси та загальний API для калькулятора.
calc-core: Реалізація основних функцій калькулятора.
calc-main: Головний модуль, що містить точку входу та реалізує консольний застосунок.
Програма виконує чотири арифметичні операції (додавання, віднімання, множення, ділення) та також виконує додаткове завдання за вашим варіантом.

Структура проєкту:
calculator/
├── pom.xml
├── README.md
├── calc-api/
│   ├── pom.xml
│   ├── README.md
│   └── src/
│       └── main/
│           └── java/
│               └── ua/edu/dnu/fpm/calc/api/
│                   └── Calc.java
├── calc-core/
│   ├── pom.xml
│   ├── README.md
│   └── src/
│       └── main/
│           └── java/
│               └── ua/edu/dnu/fpm/calc/core/
│                   └── CalcImpl.java
└── calc-main/
    ├── pom.xml
    ├── README.md
    └── src/
        └── main/
            └── java/
                └── ua/edu/dnu/fpm/calc/main/
                    └── App.java

Вимоги:
Java 8 або вище
Maven 3.6 або вище

Збірка проєкту:
У кореневій директорії проєкту виконайте команду:
mvn clean install
Це збере всі модулі та створить запускаємий JAR-файл у модулі calc-main.

Запуск застосунку:
Після збірки ви можете запустити застосунок за допомогою команди:
java -jar calc-main/target/calc-main-1.0-SNAPSHOT-jar-with-dependencies.jar number1 number2 operator 
number1 та number2 — числа для виконання операції.
operator — оператор (+, -, *, / або їх текстові аналоги add, subtract, multiply, divide).
[додаткові аргументи] — додаткові аргументи для аналізу.

Приклади запуску:
Додавання
java -jar calc-main/target/calc-main-1.0-SNAPSHOT-jar-with-dependencies.jar 100 -100 +
Вивід:
number1=100 number2=-100 operator=+ result=0
Total args: 3, Number args: 2, Max number: 100

Множення з додатковими аргументами
java -jar calc-main/target/calc-main-1.0-SNAPSHOT-jar-with-dependencies.jar 10 5 multiply extra_arg 20
Вивід:
number1=10 number2=5 operator=multiply result=50
Total args: 5, Number args: 3, Max number: 20

Опис функціональності
Програма виконує вказану арифметичну операцію над двома числами та виводить результат. Також вона аналізує всі передані аргументи (крім оператора) та:

Визначає, які з них є цілими числами.
Знаходить максимальне число серед цілих чисел.
Виводить кількість заданих параметрів, кількість числових параметрів та максимальне число.
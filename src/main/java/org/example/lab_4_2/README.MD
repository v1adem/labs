# Лабораторна робота №4_2

## Функціональність програми

**Завдання:**

- У далекій галактиці існують повідомлення, зашифровані в дивних шаблонах, які потребують декодування.
- Вам було доручено написати програму на Java, яка розшифровує ці повідомлення.

- Кодування заміни голосних: усі голосні (a, e, i, o, u) замінюються на числа: a=1, e=2, i=3, o=4, u=5. Наприклад, "t2st3ng" повинно бути "testing".
- Кодування заміни приголосних: всі приголосні замінюються на наступний приголосний в послідовності. Наприклад, "ufttjoh" повинно бути "testing"

## Опис роботи

- Створив клас [Decoder]
  - Функцію `decode()`, яка виявляє тип кодування
  - Функцію `vowelsDecode()`, яка декодує текст закодований першим типом
  - Функцію `consonantsDecode()`, яка декодує текст закодований другим типом
- Створив клас [Coder]
  - Функцію `vowelsCode()`, яка декодує текст закодований першим типом
  - Функцію `consonantsCode()`, яка декодує текст закодований другим типом
- Покрив їх [тестами]

## Висновок

**Під час виконання лабораторної роботи я здобув навички роботи зі строками у Java**

[Decoder]: Decoder.java
[Coder]: Coder.java
[тестами]: ../../../../../test/java/org/example/lab_4_2/DecoderTest.java
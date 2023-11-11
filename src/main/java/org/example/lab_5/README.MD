# Лабораторна робота №5

## Функціональність програми

**Завдання:**

    Реалізуйте клас BankAccount з членами класу accountNumber, accountName і balance.
    Реалізуйте методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary().
    Створіть спеціалізовані класи винятків:
        InsufficientFundsException
        NegativeAmountException
        AccountNotFoundException
    Реалізуйте клас Bank, який зберігає колекцію об'єктів BankAccount.
    У класі Bank, реалізуйте методи:
        createAccount(String accountName, double initialDeposit)
        findAccount(int accountNumber)
        transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
    Обробляйте винятки відповідно в кожному методі.
    Створіть тестові класи, де ви моделюєте різні сценарії для тестування обробки виняткових ситуацій.

## Опис роботи

- Створив клас [BankAccount]
  - Функцію `deposit()`, яка кладе певну кількість грошей на рахунок
  - Функцію `withdraw()`, яка знімає і повертає певну кількість грошей з рахунку
  - Функцію `getBalance()`, яка повертає стан рахунку
- Створив клас [Bank]
  - Функцію `createAccount()`, яка створює аккаунт з початковим балансом
  - Функцію `findAccount()`, яка знаходить і повертає `BankAccount` за `id` (accountNumber)
  - Функцію `tranferMoney()`, яка переводить певну суму грошей з одного рахунку на інший
- Створив свої [exceptions]
- Покрив їх [тестами]

## Висновок

**Під час виконання лабораторної роботи я здобув навички роботи з винятками в Java**

[BankAccount]: BankAccount.java
[Bank]: Bank.java
[exceptions]: exceptions
[тестами]: ../../../../../test/java/org/example/lab_5/BankTest.java
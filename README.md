# UI_API_Tests
Задания:

1️. Cleanuri

Написать авто-тесты для тестирования api сервиса cleanui.com (https://cleanuri.com/docs )
- Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его авто-тестами
- Тестовые данные (строка со ссылкой на сайт, которая будет "укорачиваться" в рамках работы тестируемого сервиса) необходимо вычитывать из внешнего файла

2. Randomuser

Написать автотесты для тестирования api сервиса randomuser.me (https://randomuser.me/documentation#howto )
- Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его автотестами
- При выполнении api-запросов необходимо использовать query-параметры (например, gender=male или results=2)
- Ответы сервиса необходимо распарсить в Java-объекты и выполнить проверки (asserts) с использованием этих объектов (рекомендовано применение коллекций и stream api)

3. Demoqa

Написать автотесты для тестирования формы https://demoqa.com/automation-practice-form
- Заполнить форму валидными данными (все поля)
- Нажать на кнопку Submit
- Проверить корректность заполнения формы (результаты во всплывающем окне "Thanks for submitting the form")
- Также реализовать негативные проверки формы (валидация полей)

4. Sovcombank

Написать авто-тест для страницы сайта https://people.sovcombank.ru/vacancies :
- Перейти на страницу https://people.sovcombank.ru/
- Нажать на кнопку "Вакансии"
- Выбрать в фильтре вакансий Город = "Москва", Компания = "Совкомбанк Технологии"
- Собрать в коллекцию результаты работы фильтра (все найденные после фильтрации вакансии)
- Проверить, что у всех найденных результатов указан город "Москва" и компания "Совкомбанк Технологии"
- Рекомендуется применение паттерна PageObject
- Использование локаторов - css или xpath

🏛️ Требования к стеку технологий и ПО
1.	Java 17
2.	Maven
3.	JUnit 5
4.	IDE IntelliJ Idea
5.	Rest Assured для api-тестов
6.	Selenide для UI-тестов (браузер - chrome)
7.	Asserts - AsserJ



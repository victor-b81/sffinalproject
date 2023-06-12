# sffinalproject
Финальный проект skillfactory  
API для Интернет-банка  
  
Реализован Rest API по работе с банковским счетом.  

Демонстрационная версия развернута на базе хостинга https://railway.app
  ссылка для обращений https://sffinalproject-production.up.railway.app/
  
Доступны следующие функции:  
    Узнать баланс по ID пользователя; Метод GET https://sffinalproject-production.up.railway.app/getBalance?getUserIdParam=1  
    Снятие заданной суммы с баланса пользователя; Метод POST https://sffinalproject-production.up.railway.app//takeMoney?tUserId=2&tMoney=70  
    Пополнение баланса на заданную сумму;  Метод POST  https://sffinalproject-production.up.railway.app//putMoneу?getUserIdParam=1&putMoneyParam=2222  
    Перевести заданную сумму другому пользователю;  Метод POST https://sffinalproject-production.up.railway.app//transferMoney?sendUserId=1&recipUserId=2&tMoney=7  
    Получить историю операций. Метод GET https://sffinalproject-production.up.railway.app/getOperationList?userId=1&dateBegin=2023-01-01&dateEnd=2024-01-01    

![alt text](https://github.com/victor-b81/sffinalproject/blob/master/src/screenshotdb/Screenshot_1.png?raw=true)


# sffinalproject
Финальный проект skillfactory  
API для Интернет-банка  
  
Реализован Rest API по работе с банковским счетом.  

Демонстрационная версия развернута на бае хостинга https://railway.app
  ссылка для обращений https://sffinalproject-production.up.railway.app/
  
Доступны следующие функции:  
    Узнать баланс по ID пользователя;   https://sffinalproject-production.up.railway.app/getBalance?getUserIdParam=1  
    Снятие заданной суммы с баланса пользователя;  https://sffinalproject-production.up.railway.app//takeMoney?tUserId=2&tMoney=70  
    Пополнение баланса на заданную сумму;  https://sffinalproject-production.up.railway.app//putMoneу?getUserIdParam=1&putMoneyParam=2222  
    Перевести заданную сумму другому пользователю; https://sffinalproject-production.up.railway.app//transferMoney?sendUserId=1&recipUserId=2&tMoney=7  
    Получить историю операций. https://sffinalproject-production.up.railway.app//getOperationList?userID=1  

![alt text](https://github.com/victor-b81/sffinalproject/blob/master/src/screenshotdb/Screenshot_1.png?raw=true)


# logest
EXCEL's LOGEST function implemented in Java. I use it to calculate growth rate.

It seems like there isn't a best way to determine growth rate (EPS, DPS, ...) calculation.

https://money.stackexchange.com/questions/88105/better-way-to-calculate-earning-growth-rate-to-have-quick-glance-on-company-earn

* Arithmetic average growth - Doesn't seem like a standard used in financial industry.

* Geometric average growth - It only take account into value during starting period and value during ending period. It doesn't care about values in between the period.

I found a more reasonable way, by using "least square regression". It takes account into every values.

https://docs.google.com/spreadsheets/d/1ff5rpk6bilrRlzaNAqgvMojVrAnQ3ItWZUW1YeQvymQ/edit#gid=0

http://faq.betterinvesting.org/index.php?action=artikel&cat=3&id=16&artlang=en

http://science.clemson.edu/physics/labs/tutorials/excel/regression.html

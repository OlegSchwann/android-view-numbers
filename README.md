# Домашнее задание 1 по курсу Android.

Требуется написать Android приложение с двумя фрагментами и одной Activity. 

Первый фрагмент должен отображать список чисел от 1 до 100 в сетке
и одну кнопку, по нажатию на которую должен добавить элемент в конце списка.
Необходимо, чтобы в портретной ориентации было 3 столбца в сетке,
а в альбомной - 4. Высота и ширина View, отображающей число, должна быть не
меньше 48dp по каждой стороне. Чётные числа должны быть написаны красным
шрифтом, нечетные - синим.
  
При клике на любое число должен открываться второй фрагмент, заменяя собой
первый, и отображать выбранное число крупным шрифтом и тем же цветом, что и в
списке. По кнопке back должен производиться возврат в список чисел.

При добавлении элемента нельзя пересоздавать адаптер.
# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 7 -  Obtenir l'edat de la persona més jove

import pandas as pd

titanic = pd.read_csv("titanic.csv")
minAge = titanic["Age"].min()
print(minAge)

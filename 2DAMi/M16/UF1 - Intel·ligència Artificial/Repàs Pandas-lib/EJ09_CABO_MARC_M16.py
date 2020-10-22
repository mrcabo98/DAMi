# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 9 - Mostra la edat mitja del supervivents

import pandas as pd

titanic = pd.read_csv("titanic.csv")

supervivents = titanic[(titanic["Survived"] == 1)]
ageAverage = supervivents["Age"].mean
print(ageAverage)

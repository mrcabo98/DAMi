# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 5 - Obtenir el nombre de persones amb menys de 30 anys

import pandas as pd

titanic = pd.read_csv("titanic.csv")

# Obtenim el nombre de persones amb menys de 30 anys
under_30 = titanic[titanic["Age"] < 30]
print(under_30)

# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 6 -  Obtenir el Nom, Sexe, Edat de les persones amb menys de 30 anys

import pandas as pd

titanic = pd.read_csv("titanic.csv")

under30_filterList = titanic.loc[titanic["Age"] < 30, ["Name", "Sex", "Age"]]
print(under30_filterList)

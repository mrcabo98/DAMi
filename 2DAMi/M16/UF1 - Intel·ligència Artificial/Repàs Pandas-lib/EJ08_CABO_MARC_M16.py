# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 8 - Oobtenir el nom de la persona més gran

import pandas as pd

titanic = pd.read_csv("titanic.csv")
maxAge = titanic.loc[titanic["Age"].max(), "Name"]
print(maxAge)

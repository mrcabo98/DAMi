# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 2 - Mostra el identificador de les columnes

import pandas as pd

titanic = pd.read_csv("titanic.csv")

print(titanic.dtypes)

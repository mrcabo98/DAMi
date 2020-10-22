# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 1 - Mostra la mida del dataset (nombre de persones (mostres) i nombre de característiques)

import pandas as pd

# Importem el ficher titanic.csv
titanic = pd.read_csv("titanic.csv")

# Mostrem tots el registres
print(titanic)

# Mostrem el nombre de característiques
print("Total de característiques : ", titanic.shape)

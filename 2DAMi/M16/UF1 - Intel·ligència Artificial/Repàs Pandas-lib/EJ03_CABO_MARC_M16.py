# Author : Marc Cabo Dieguez
# Date : 22/10/2021
# Ejercici 3 - Obtenir els 5 primers passatgers

import pandas as pd

titanic = pd.read_csv("titanic.csv")

# Mostrem el 5 primers passatgers
print(titanic.head(5))

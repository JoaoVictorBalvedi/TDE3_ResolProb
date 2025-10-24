# Comparação de Algoritmos de Ordenação

Este projeto implementa **Comb Sort**, **Gnome Sort**, **Bucket Sort**, **Bubble Sort com flag de parada**, **Selection Sort** e **Cocktail Sort**, todos **sem uso de funções prontas de ordenação**.  

Cada execução mede duas métricas:  
- **iterations**: quantidade de comparações principais  
- **swaps**: quantidade de trocas ou movimentos efetivos de elementos  

No Bucket Sort, as trocas representam os deslocamentos feitos pelo *insertion sort* interno de cada balde.


## Vetores de teste

**Vetor 1 — Estilo aleatório**  
`12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28`

**Vetor 2 — Quase ordenado crescente**  
`5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32`

**Vetor 3 — Decrescente**  
`99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6`

---

## Ranking por trocas de elementos (menor é melhor)

### Vetor 1 — Estilo aleatório
| Rank | Algoritmo  | Swaps |
| ---: | ---------- | ----: |
|    1 | Bucket     |     2 |
|    2 | Selection  |    18 |
|    3 | Comb       |    22 |
|    4 | Gnome      |    78 |
|    4 | BubbleFlag |    78 |
|    4 | Cocktail   |    78 |



### Vetor 2 — Quase ordenado crescente
| Rank | Algoritmo  | Swaps |
| ---: | ---------- | ----: |
|    1 | Bucket     |     0 |
|    1 | Gnome      |     0 |
|    1 | BubbleFlag |     0 |
|    1 | Cocktail   |     0 |
|    1 | Comb       |     0 |
|    1 | Selection  |     0 |


### Vetor 3 — Decrescente
| Rank | Algoritmo  | Swaps |
| ---: | ---------- | ----: |
|    1 | Selection  |    10 |
|    2 | Comb       |    18 |
|    3 | Bucket     |    20 |
|    4 | Gnome      |   190 |
|    4 | BubbleFlag |   190 |
|    4 | Cocktail   |   190 |

---

## Ranking por interações do laço (menor é melhor)

### Vetor 1 — Estilo aleatório
| Rank | Algoritmo  | Iterations |
| ---: | ---------- | ---------: |
|    1 | Bucket     |          2 |
|    2 | Comb       |        129 |
|    3 | Cocktail   |        154 |
|    4 | Gnome      |        174 |
|    5 | BubbleFlag |        180 |
|    6 | Selection  |        190 |


### Vetor 2 — Quase ordenado crescente
| Rank | Algoritmo  | Iterations |
| ---: | ---------- | ---------: |
|    1 | Bucket     |          2 |
|    2 | Gnome      |         19 |
|    2 | BubbleFlag |         19 |
|    2 | Cocktail   |         19 |
|    5 | Comb       |        110 |
|    6 | Selection  |        190 |


### Vetor 3 — Decrescente
| Rank | Algoritmo  | Iterations |
| ---: | ---------- | ---------: |
|    1 | Bucket     |         20 |
|    2 | Comb       |        129 |
|    3 | BubbleFlag |        190 |
|    3 | Selection  |        190 |
|    3 | Cocktail   |        190 |
|    6 | Gnome      |        380 |

---

## Síntese de quando cada um foi melhor

### Cenário quase ordenado
Todos fizeram zero trocas.  
Em interações, o melhor foi **Bucket**, seguido de **Gnome**, **BubbleFlag** e **Cocktail** empatados.  
**Comb** precisou de mais passagens por causa do encolhimento de *gap*, e **Selection** percorre sempre tudo.

### Cenário decrescente
Menos trocas foi do **Selection**, por fazer no máximo uma troca por posição.  
Em interações o melhor foi **Bucket**, seguido de **Comb**; os baseados em troca adjacente tiveram desempenho inferior.

### Cenário aleatório curto
**Bucket** foi o melhor em ambas as métricas.  
**Comb** se destacou em interações por reduzir rapidamente inversões longas.  
**Selection** trocou pouco, mas comparou muito.

---

## Metodologia

Os contadores foram implementados de forma simples e explícita:  
- **Bubble** e **Cocktail**: uma comparação a cada checagem de par adjacente.  
- **Selection**: uma comparação por par candidato no subarray restante.  
- **Bucket**: contagem reflete comparações e deslocamentos do *insertion sort* interno.  

Nenhuma biblioteca de ordenação foi utilizada.

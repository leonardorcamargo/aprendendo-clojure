; Exemplo de vetores:
; (def numeros [1 2 3 2 1 4])

; Exemplo de conjuntos:
; (def numeros #{1 2 3 4 /5})

; Função contains?
; O ponto de interrogação no final do nome da função indica que ela irá fazer uma validação e retornar
; true ou false. A função contains? verifica se existe um elemento dentro de 
; Exemplo de uso:
; (contains? "TESTE" "E") => true

; Função .contains
; Faz a mesma coisa que contains?. Com diferencial de ser invocado diretamente dos pacotes Java.

; Função recur
; Utilizada no final de funções recursivas, para caso a seja a última linha da função, esta não entre na pilha

; Função remove
; A função remove recebe dois parâmetros, uma função que retorna true ou false e um conjunto. Cada item do conjunto
; será passado para função e de acordo com o retorno será removida ou não do conjunto. Lembrando que o conjunto 
; original não será afetado, o remove irá retornar um novo conjunto com os dados restantes.

(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu"))
(defn ganhou [] (print "Você ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos))
)

(defn acertou? [chute palavra] (.contains palavra chute))

(defn le-letra! [] (read-line))

(defn jogo [vidas palavra acertos]
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Acertou a letra!")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Errou a letra! Perdeu vida!")
          (recur (dec vidas) palavra acertos))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

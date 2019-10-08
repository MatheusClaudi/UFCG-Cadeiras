import System.IO 
import System.Process
import Control.Monad (when)

type Peso = Double
type Pontos = Double
type NomeNota = String
type Considerar = Bool
data Nota = Nota Peso Pontos NomeNota Considerar
                                                   deriving (Show, Read)

type NomeDisciplina = String
type Sala = String
type Professor = String
type Notas = [Nota]
data Disciplina = Disciplina NomeDisciplina Sala Professor Notas
                                                                   deriving (Show, Read)

getKey :: IO [Char]
getKey = reverse <$> getKey' ""
  where getKey' chars = do
          char <- getChar
          more <- hReady stdin
          (if more then getKey' else return) (char:chars)
a1 = do
  system "clear"
  putStr("o1")

a2 = do
  system "clear"
  putStr("o2")

a3 = do
  system "clear"
  putStr("o3")

a4 = do
  system "clear"
  putStr("o4")

changeMainScreen :: Integer -> IO()
changeMainScreen 0 = do a1
changeMainScreen 1 = do a2
changeMainScreen 2 = do a3
changeMainScreen 3 = do a4

                 
optionsMainScreen :: [String]
optionsMainScreen = [" Disciplinas", " Compromissos", " Configuracoes", " Tutorial"]

actionMainScreen :: [Integer] -> [Integer] -> Integer -> [Char] -> IO()
actionMainScreen disciplinas compromissos cursor action | action == "\ESC[B" = mainScreen disciplinas compromissos ((cursor+1) `mod` 4)
                                                        | action == "\ESC[A" && cursor /= 0 = mainScreen disciplinas compromissos (cursor-1)
                                                        | action == "\ESC[A" && cursor == 0 = mainScreen disciplinas compromissos 3
                                                        | action == "\ESC[C" = changeMainScreen cursor
                                                        | action == "\ESC[D" = return ()

showMainScreen :: [String] -> Integer -> Integer -> IO()
showMainScreen [] cursor contador = return ()
showMainScreen (o:os) cursor contador = do
   if contador == cursor
      then 
      putStrLn("->" ++ o)
   else
      putStrLn("  " ++ o)
   showMainScreen os cursor (contador+1)


mainScreen :: [Integer] -> [Integer] -> Integer -> IO ()
mainScreen disciplinas compromissos cursor = do
   
   system "clear"
   showMainScreen optionsMainScreen cursor 0
   
   hSetBuffering stdin NoBuffering
   hSetEcho stdin False
   key <- getKey
   actionMainScreen disciplinas compromissos cursor key



main :: IO ()
main = do
   mainScreen [] [] 0

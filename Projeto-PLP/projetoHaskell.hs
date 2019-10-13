import System.IO 
import System.Process
import Control.Monad (when)

type Peso = Double
type Pontos = Double
type NomeNota = String
type Considerar = Bool
data Nota = Nota Peso Pontos NomeNota Considerar
                                                   deriving (Show, Read)
                  

type Disciplinas = [Disciplina]                                                   
type NomeDisciplina = String
type Sala = String
type Professor = String
type Notas = [Nota]
data Disciplina = Disciplina NomeDisciplina Sala Professor Notas
                                                                   deriving (Show, Read)

type Compromissos = [Compromisso]                                                                   
data Compromisso = Compromisso
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


a4 = do
  system "clear"
  putStr("o4")




changeMainScreen :: Disciplinas -> Compromissos -> Integer -> IO()
changeMainScreen disciplinas compromissos cursor | cursor == 0 = do a1;
                                                 | cursor == 1 = do a2;                
                                                 | cursor == 2 = do configuracoesScreen disciplinas compromissos 0 
                                                 | cursor == 3 = do a4

                 
optionsMainScreen :: [String]
optionsMainScreen = [" Disciplinas", " Compromissos", " Configuracoes", " Tutorial"]

optionsConfiguracoesScreen :: [String]
optionsConfiguracoesScreen = [" Cadastrar disciplina", " Atualizar disciplina", " Remover disciplina", " Resetar sistema"]

doMainScreen :: Disciplinas -> Compromissos -> Integer -> [Char] -> IO()
doMainScreen disciplinas compromissos cursor action | action == "\ESC[B" = mainScreen disciplinas compromissos ((cursor+1) `mod` 4)
                                                    | action == "\ESC[A" && cursor /= 0 = mainScreen disciplinas compromissos (cursor-1)
                                                    | action == "\ESC[A" && cursor == 0 = mainScreen disciplinas compromissos 3
                                                    | action == "\ESC[C" = changeMainScreen disciplinas compromissos cursor
                                                    | action == "\ESC[D" = exitScreen disciplinas compromissos
                                                    | otherwise = mainScreen disciplinas compromissos cursor

showSimpleScreen :: [String] -> Integer -> Integer -> IO()
showSimpleScreen [] cursor contador = return ()
showSimpleScreen (o:os) cursor contador = do
   if contador == cursor
      then 
      putStrLn("->" ++ o)
   else
      putStrLn("  " ++ o)
   showSimpleScreen os cursor (contador+1)


mainScreen :: Disciplinas -> Compromissos -> Integer -> IO ()
mainScreen disciplinas compromissos cursor = do
   
   system "clear"
   showSimpleScreen optionsMainScreen cursor 0
   
   hSetBuffering stdin NoBuffering
   hSetEcho stdin False
   action <- getKey
   doMainScreen disciplinas compromissos cursor action


endRun :: IO ()
endRun = do
   system "clear"
   putStrLn("Obrigado por Utilizar")
   pause <- getKey
   system "clear"
   putStr ""

doExitScreen :: Disciplinas -> Compromissos -> String -> IO ()
doExitScreen disciplinas compromissos action | action == "s" = endRun
                                             | otherwise = mainScreen disciplinas compromissos 0
    
exitScreen :: Disciplinas -> Compromissos -> IO ()
exitScreen disciplinas compromissos = do
   system "clear"
   putStrLn("Digite (s) para encerrar a execucao ou (Outra tecla) para voltar para o menu");
   
   hSetBuffering stdin NoBuffering
   hSetEcho stdin False
   action <- getKey
   doExitScreen disciplinas compromissos action

changeConfiguracoesScreen :: Integer -> IO()
changeConfiguracoesScreen 0 = do a1
changeConfiguracoesScreen 1 = do a2
changeConfiguracoesScreen 2 = do a2
changeConfiguracoesScreen 3 = do a4

doConfiguracoesScreen :: Disciplinas -> Compromissos -> Integer -> [Char] -> IO()
doConfiguracoesScreen disciplinas compromissos cursor action | action == "\ESC[B" = configuracoesScreen disciplinas compromissos ((cursor+1) `mod` 4)
                                                    | action == "\ESC[A" && cursor /= 0 = configuracoesScreen disciplinas compromissos (cursor-1)
                                                    | action == "\ESC[A" && cursor == 0 = configuracoesScreen disciplinas compromissos 3
                                                    | action == "\ESC[C" = changeConfiguracoesScreen cursor
                                                    | action == "\ESC[D" = mainScreen disciplinas compromissos 0
                                                    | otherwise = configuracoesScreen disciplinas compromissos cursor


configuracoesScreen :: Disciplinas -> Compromissos -> Integer -> IO ()
configuracoesScreen disciplinas compromissos cursor = do
   
   system "clear"
   showSimpleScreen optionsConfiguracoesScreen cursor 0
   
   hSetBuffering stdin NoBuffering
   hSetEcho stdin False
   action <- getKey
   doConfiguracoesScreen disciplinas compromissos cursor action

run :: IO ()
run = do
   mainScreen [] [] 0

main :: IO ()
main = do
   run

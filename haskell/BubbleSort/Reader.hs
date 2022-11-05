import System.IO

main :: IO ()

var :: [String]
main = do
   myFile <- openFile "hello.txt" ReadMode
   line <- hGetLine myFile
   putStrLn line
   var = []
   var ++[line]
   hClose myFile
   putStrLn "done!"

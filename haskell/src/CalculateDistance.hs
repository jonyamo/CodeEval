-- module Main where
module CalculateDistance where

import Data.Char (isDigit)
import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map getDistance
         $ map getNumbers
         $ lines contents

getNumbers :: String -> [String]
getNumbers nums = words [x | x <- nums, isDigit x || x == '-' || x == ' ']

getDistance :: [String] -> String
getDistance xs =
  let x1 = read (xs !! 0) :: Int
      y1 = read (xs !! 1) :: Int
      x2 = read (xs !! 2) :: Int
      y2 = read (xs !! 3) :: Int
  in  show $ getDistance' x1 y1 x2 y2

getDistance' :: (Integral a) => a -> a -> a -> a -> a
getDistance' x1 y1 x2 y2 = round . sqrt . fromIntegral $ (x2 - x1)^2 + (y2 - y1)^2

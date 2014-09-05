<?php
namespace CodeEval;

class HiddenDigits
{
    protected $text;

    public function __construct($text)
    {
        $this->text = $text;
    }

    public function getHiddenDigits()
    {
        $hidden_digits = preg_match_all('/[a-j]|\d/', $this->text, $matches);
        if (!$matches = array_shift($matches)) {
            return "NONE";
        }
        return implode("", str_replace(range('a','j'), range(0,9), $matches));
    }

    public static function loadFromFile($filename)
    {
        $lines = file($filename,
            FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        if ($lines === false) {
            throw new \Exception("Invalid file: {$filename}");
        }
        $hds = array();
        foreach ($lines as $line) {
            $hds[] = new \CodeEval\HiddenDigits($line);
        }
        return $hds;
    }
}

$hds = \CodeEval\HiddenDigits::loadFromFile($argv[1]);
foreach ($hds as $hd) {
    fwrite(STDOUT, $hd->getHiddenDigits() . PHP_EOL);
}

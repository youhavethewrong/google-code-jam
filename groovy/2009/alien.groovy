/* Alien language interpretation.
 *
 */

import java.util.regex.Pattern

def interpret(dict, pattern) {
    return dict.findAll { it =~ pattern }.size()
}

def main() {
    def fh = new File(args[0])
    def lines = fh.readLines()
    def scenario = lines[0].split(" ")

    def wordLength = Integer.valueOf(scenario[0])
    def dictSize   = Integer.valueOf(scenario[1])
    def patternCount  = Integer.valueOf(scenario[2])

    def dict = []
    for( def h=1; h <= dictSize; h++ ) {
        dict[h-1] = lines[h]
    }

    def patterns = []
    for( def i=dictSize+1; i <= patternCount+dictSize; i++ ) {
        patterns[i-dictSize-1] = lines[i]
    }

    for( def j=1; j <= patternCount; j++ ) {
        def pattern = patterns[j-1]
        pattern = pattern.replaceAll("\\(", "\\[")
        pattern = pattern.replaceAll("\\)", "\\]")
        println "Case #$j: "+interpret(dict, ~/${pattern}/)
    }
}

main()

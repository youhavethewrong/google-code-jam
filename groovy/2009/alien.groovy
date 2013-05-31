/* Alien language interpretation.
 *
 */

def interpret(dict, pattern) {
    return dict.findAll { it ==~ /pattern/ }
}

def main() {
    def fh = new File(args[0])
    def lines = fh.readLines()
    def scenario = lines[0].split(" ")

    def wordLength = scenario[0]
    def dictSize   = scenario[1]
    def patternCount  = scenario[2]

    def dict = [dictSize]
    for( def h=1; h <= dictSize; h++ ) {
        dict[h] = lines[h]
    }

    def patterns = [caseCount]
    for( def i=dictSize+1; i <= patternCount+dictSize; i++ ) {
        patterns[i] = lines[i]
    }

    for( def j=1; j <= caseCount; j++ ) {
        def pattern = patterns[j]
        pattern.replaceAll("\\(", "\\[")
        pattern.replaceAll("\\)", "\\]")
        println "Case #$j: "+interpret(dict, pattern)
    }
}

main()

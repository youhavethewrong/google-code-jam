/* Calculate minimum scalar product by permuting the two input vectors.
 * ESC 2013.05.26
 */

def minimize(len, v1, v2) {
    def sum = 0
    v1 = v1.sort()
    v2 = v2.sort().reverse()
    for (def i=0; i < v1.size(); i++) {
        sum += v1[i] * v2[i]
    }
    return sum
}

def main() {
    def fh = new File(args[0])
    def lines = fh.readLines()
    def caseCount = Integer.valueOf(lines[0])
    def cases = [:]

    for(def i=1; i <= caseCount; i++) {
        def index = 3*(i-1)+1

        def v1 = lines[index+1].split(" ")
        v1 = v1.collect { Integer.valueOf(it) }

        def v2 = lines[index+2].split(" ")
        v2 = v2.collect { Integer.valueOf(it) }

        cases[(i)] = [len:lines[index], v1:v1, v2:v2]
    }

    for( def j in cases.keySet() ) {
        def caseRun = cases[j]
        println "Case #$j: "+minimize(caseRun['len'], caseRun['v1'], caseRun['v2'])
    }
}

main()

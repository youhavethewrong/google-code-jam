/* Calculate minimum scalar product by permuting the two input vectors.
 * ESC 2013.05.26
 */

def minimize(len, v1, v2) {
    return 42
}

def main() {
    fh = new File(args[0])
    lines = fh.readLines()
    caseCount = Integer.valueOf(lines[0])
    def cases = [:]
    for(i=1; i <= caseCount; i++) {
        index = 3*(i-1)+1
        cases[(i)] = [len:lines[index], v1:lines[index+1].split(" "), v2:lines[index+2].split(" ")]
    }

    for( j in cases.keySet() ) {
        def caseRun = cases[j]
        println "Case #$j: "+minimize(caseRun['len'], caseRun['v1'], caseRun['v2'])
    }
}

main()

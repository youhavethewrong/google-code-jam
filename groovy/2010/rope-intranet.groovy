/* Calculate the intersection points of a rope intranet.
 *
 */

def intersections(links) {
    def intersectionCount = 0
    // for each link l
        // for each other link m
            // if l.a < m.a or m.b < l.b
                // count++
            // else if l.b < m.a or m.b < l.a
                // count++

    // count = count / 2

    return intersectionCount
}

def main() {
    def fh = new File(args[0])
    def lines = fh.readLines()
    def caseCount = Integer.valueOf(lines[0])
    def index = 1;
    
    for(def i=0; i < caseCount; i++) {
        def links = [:]
        def linkCount = Integer.valueOf(lines[index])

        for(def j=1; j <= linkCount; j++) {
            def endPoints = lines[index+j].split(" ")
            def linkA = endPoints[0]
            def linkB = endPoints[1]
            links[(j-1)] = [linkA:Integer.valueOf(linkA), linkB:Integer.valueOf(linkB)]
        }

        intersections(links)
        index += linkCount+1
    }
}

main()

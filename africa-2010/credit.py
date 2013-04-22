"""


"""

import sys

def check_pair(tot, index, iteml):
    for i in range(len(iteml)):
        #print "Checking if %s + %s = %s" % (item, i, tot)
        if (index != i and int(iteml[index]) + int(iteml[i]) == int(tot)):
            return i
    return -1

def find_match(credit, itemc, iteml):
    for i in range(itemc):
        res = check_pair(credit, i, iteml)
        if res > 0:
            # 1-based indexing... really
            return i+1,res+1
    return -1,-1

fh = open(sys.argv[1], 'r')
case_count = int(fh.readline())
case_info = {}
for i in range(case_count):
    case_info[i] = {'credit':int(fh.readline()), 'itemc':int(fh.readline()), 'iteml':fh.readline()[:-1]}

for i in range(len(case_info)):
    case = case_info[i]
    print "Case #"+str(i+1)+": "+"%s %s" % find_match(case['credit'], case['itemc'], case['iteml'].split(' '))

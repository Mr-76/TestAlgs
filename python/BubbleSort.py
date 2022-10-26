def read(string):
    with open(string, "r") as file:
        array = file.readlines()
    return array


def BubbleSort(arrayOrdenar):
    for index in range(1, len(arrayOrdenar)):
        for index2 in range(0, len(arrayOrdenar) - index):
            if(arrayOrdenar[index2] > arrayOrdenar[index2+1]):
                array[index2], array[index2+1] = array[index2+1], array[index2];
    
    print(array)


if (__name__ == "__main__"):
    array = read("text.txt")
    BubbleSort(array)

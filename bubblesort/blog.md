**Bubble Sort**

Hi there! This ‘Concepts-as-Code’ blog post is the first in a series where I will attempt to explain concepts in Computer Science in the simplest ways that I can.

As someone who didn’t have a formalised Computer Science education, I’ve always felt like I missed out on learning the inner workings of data structures and algorithms that every software engineer should know (I’ve never been tested on them during an interview! Maybe that’s a good thing?).

![](https://cdn-images-1.medium.com/max/245/0*38a9ZdPljG0w6w2i)

So one of my blogging ambitions moving forward is to do short and sweet posts about particular concepts that I’m learning about and I can teach to others.

![](https://cdn-images-1.medium.com/max/490/0*uyknTcvY3iCwMkLB.gif)

I’ll be coding these concepts in Java as that’s the language I’m most comfortable with and use the most. I may switch it up and use Python from time to time, but we’ll see how we go.

With that out of the way, let’s start with a simple sorting algorithm called the Bubble Sort.

**Introducing the Bubble Sort**

![](https://cdn-images-1.medium.com/max/444/0*XoFS-bhw1Q1msyZa.gif)<figcaption>These aren’t the bubbles we’re looking for</figcaption>

Out of all the sorting algorithms, the Bubble Sort is the simplest.

Basically, we have an input array that the Bubble Sort will make multiple passes over. During each pass, the algorithm will compare two elements next to each other and swap them if they are unsorted. It’s called bubble sort because the sort ‘bubbles up’ from the bottom end of the list.

Let’s break this down even further. The Bubble Sort performs three simple tasks:

1. Repeatedly going through the list to sort.
2. Comparing adjacent elements (elements next to each other) in the list and sorting them.
3. Swapping them around if the first element is bigger than the second element.

Let’s have a look at some psuedocode to visualize this process better:

```
bubbleSort(inputArray)
  n = length(inputArray)
  for (k = 1 until n)
    for (j = 0 until -1)
      if(array[j] > array[j + 1])
        swap(array, j, j + 1)
```

In this psuedocode, n is the length of our array. To ensure that our entire list is sorted we need to do n — 1 passses on our list. If we had a list of 10 items, we would need to compare the second element of our list (at position 1 in the array) and keep going through it 9 times until we have sorted the entire list. A sorted bubble is building at the end of the list, this is why we need make n — 1 passes on our list.

In our if statements, we are comparing the number in our array at position j with the number at position j + 1 (the adjacent number in our list).

**Implementing Bubble Sort in Java**

Let’s turn our psuedocode into some actual Java code. Our Bubble sort method should look like this.

```
public void sortV1(int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }
}
```

Much like in our psuedocode, we need to pass through our list n — 1 times. If the number at position j is bigger than the number at position j + 1, we use a temporary variable to swap the positions of the numbers.

Let’s see it in action. We’ll create a list of numbers that we can sort in our Main method.

```
// Program entry
public static void main(String[] args) {
    // Instantiate a new instance of our BubbleSort class
    BubbleSort sort = new BubbleSort();

    // Define the input array that we wish to sort
    int[] inputArray = new int[]{6,4,3,6,4,7,9,2,4,3,1};

    // Call our sortV1 method and pass in our inputArray
    sort.sortV1(inputArray);

    // Print out the results to the console
    System._out_.println(Arrays._toString_(inputArray));
}
```

We’re basically creating a new instance of our BubbleSort class and applying the sort method on our list. We then print our sorted list to the console and we should get the following result.

```
[1, 2, 3, 3, 4, 4, 4, 6, 6, 7, 9]

Process finished with exit code 0
```

Now as you can see, the Bubble Sort is really rather easy to implement. However it’s also one of the slower sorting methods. I’ll talk about complexity and runtime in a future blog post, but for now let’s focus on how we can improve the runtime on our Bubble Sort.

![](https://cdn-images-1.medium.com/max/500/0*Soc5noHbxYPt2LnD.gif)<figcaption>Bubble Sort is pretty slow, but probably not this slow…</figcaption>

**Improving our Bubble Sort Runtime**

Before we start improving our Bubble Sort, it’s important to note that these improvements would still result in a poor runtime complexity in the worst case scenario. It’s still important to know how you can improve performance so I’ll cover one way of doing it here.

First up, let’s create a private swap method that does the swap for us.

```
// swap helper method
private void swap(int[] numbers, int a, int b) {
    int temp = numbers[a];
    numbers[a] = numbers[b];
    numbers[b] = temp;
}
```

We can also reduce the number of passes that we make on our list. Currently, if we gave our sorting method a list that was already sorted, we would still make multiple passes on it.

In order to stop this from happening, we can remove the outer loop when the list is fully sorted. In our inner loop, instead of passing through the list n — 1 times, we’ll pass through the list n-i times. This will stop the Bubble Sort algorithm just before the sorted bubble.

In our new outer loop, we check if the array is sorted by checking if any swaps were performed in the last pass. That way, if our list is already sorted, we just do one pass on the list and leave it alone.

Our new method should look like this:

```
// Bubble Sort improvement
public void sortV2(int[] numbers) {
    int i = 0;
    boolean hasSwappedOccured = true;
    while (hasSwappedOccured) {
        hasSwappedOccured = false;
        i++;
        for (int j = 0; j < numbers.length - i; j++) {
            if (numbers[j] < numbers[j + 1]) {
                swap(numbers, j, j + 1);
                hasSwappedOccured = true;
            }
        }
    }
}
```

We can now implement our new sorting method into our Main method like so:

```
// Program entry
public static void main(String[] args) {
    // Instantiate a new instance of our BubbleSort class
    BubbleSort sort = new BubbleSort();

    // Define the input array that we wish to sort
    int[] inputArray = new int[]{6,4,3,6,4,7,9,2,4,3,1};

    // Call our sortV2 method and pass in our inputArray
    sort.sortV2(inputArray);

    // Print out the results to the console
    System._out_.println(Arrays._toString_(inputArray));
}
```

And as you can see, we get the same result:

```
[1, 2, 3, 3, 4, 4, 4, 6, 6, 7, 9]

Process finished with exit code 0
```

**Conclusion**

In this post, we covered the Bubble Sort. This is one of the simplest sorting algorithms you can use, but it’s also one of the worst performing. In future posts, we’ll cover sorting techniques that perform much better than the Bubble Sort.

![](https://cdn-images-1.medium.com/max/455/0*kIexCEt-vR6mco2Z.gif)<figcaption>Not this type of sorting though….</figcaption>

If you’d like to take a closer look at the code in this post, check out my GitHub repo for it [here](https://github.com/willvelida/concepts_as_code/tree/master/bubblesort).
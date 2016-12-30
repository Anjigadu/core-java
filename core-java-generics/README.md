# Generic Questions

<div id="PageContent">

<ol>
<li>Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).<br><br></li>
<li>Will the following class compile? If not, why?
<div class="codeblock"><pre>public final class Algorithm {
    public static &lt;T&gt; T max(T x, T y) {
        return x &gt; y ? x : y;
    }
}
</pre></div>
</li>
<li>Write a generic method to exchange the positions of two different elements in an array.<br><br></li>
<li>If the compiler erases all type parameters at compile time, why should you use generics?<br><br></li>
<li>What is the following class converted to after type erasure?
<div class="codeblock"><pre>public class Pair&lt;K, V&gt; {

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(); { return key; }
    public V getValue(); { return value; }

    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    private K key;
    private V value;
}
</pre></div>
</li>
<li>What is the following method converted to after type erasure?
<div class="codeblock"><pre>public static &lt;T extends Comparable&lt;T&gt;&gt;
    int findFirstGreaterThan(T[] at, T elem) {
    // ...
}
</pre></div>
</li>
<li>Will the following method compile? If not, why?
<div class="codeblock"><pre>public static void print(List&lt;? extends Number&gt; list) {
    for (Number n : list)
        System.out.print(n + " ");
    System.out.println();
}
</pre></div>
</li>
<li>Write a generic method to find the maximal element in the range <tt>[begin, end)</tt> of a list.<br><br></li>
<li>Will the following class compile?  If not, why?
<div class="codeblock"><pre>public class Singleton&lt;T&gt; {

    public static T getInstance() {
        if (instance == null)
            instance = new Singleton&lt;T&gt;();

        return instance;
    }

    private static T instance = null;
}
</pre></div>
</li>
<li> Given the following classes:
<div class="codeblock"><pre>class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node&lt;T&gt; { /* ... */ }
</pre></div>
Will the following code compile? If not, why?
<div class="codeblock"><pre>Node&lt;Circle&gt; nc = new Node&lt;&gt;();
Node&lt;Shape&gt;  ns = nc;
</pre></div>
</li>
<li>Consider this class:
<div class="codeblock"><pre>class Node&lt;T&gt; implements Comparable&lt;T&gt; {
    public int compareTo(T obj) { /* ... */ }
    // ...
}
</pre></div>
Will the following code compile? If not, why?
<div class="codeblock"><pre>Node&lt;String&gt; node = new Node&lt;&gt;();
Comparable&lt;String&gt; comp = node;
</pre></div>
</li>
<li>How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
<div class="codeblock"><pre>public static &lt;T&gt;
    int findFirst(List&lt;T&gt; list, int begin, int end, UnaryPredicate&lt;T&gt; p)
</pre></div>
Note that two integers <em>a</em> and <em>b</em> are relatively prime if gcd(<em>a, b</em>) = 1, where gcd is short for greatest common divisor.</li>
</ol>

# Generic Questions Answer
<div id="PageContent">

<ol>
<li>Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).<br><br>
<strong>Answer</strong>:
<div class="codeblock"><pre>public final class Algorithm {
    public static &lt;T&gt; int countIf(Collection&lt;T&gt; c, UnaryPredicate&lt;T&gt; p) {

        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
}
</pre></div>
where the generic <tt>UnaryPredicate</tt> interface is defined as follows:
<div class="codeblock"><pre>public interface UnaryPredicate&lt;T&gt; {
    public boolean test(T obj);
}
</pre></div>
For example, the following program counts the number of odd integers in an integer list:
<div class="codeblock"><pre>import java.util.*;

class OddPredicate implements UnaryPredicate&lt;Integer&gt; {
    public boolean test(Integer i) { return i % 2 != 0; }
}

public class Test {
    public static void main(String[] args) {
        Collection&lt;Integer&gt; ci = Arrays.asList(1, 2, 3, 4);
        int count = Algorithm.countIf(ci, new OddPredicate());
        System.out.println("Number of odd integers = " + count);
    }
}
</pre></div>
The program prints:
<div class="codeblock"><pre>Number of odd integers = 2
</pre></div>
</li>
<li>Will the following class compile? If not, why?
<div class="codeblock"><pre>public final class Algorithm {
    public static &lt;T&gt; T max(T x, T y) {
        return x &gt; y ? x : y;
    }
}
</pre></div>
<strong>Answer</strong>: No. The greater than (<tt>&gt;</tt>) operator applies only to primitive numeric types.<br><br>
</li>
<li>Write a generic method to exchange the positions of two different elements in an array.<br><br>
<strong>Answer</strong>:
<div class="codeblock"><pre>public final class Algorithm {
    public static &lt;T&gt; void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
</pre></div>
</li>
<li>If the compiler erases all type parameters at compile time, why should you use generics?<br><br>
<strong>Answer</strong>: You should use generics because:
<ul>
<li>The Java compiler enforces tighter type checks on generic code at compile time.</li>
<li>Generics support programming types as parameters.</li>
<li>Generics enable you to implement generic algorithms.</li>
</ul>
<br><br>
</li>
<li>What is the following class converted to after type erasure?
<div class="codeblock"><pre>public class Pair&lt;K, V&gt; {

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(); { return key; }
    public V getValue(); { return value; }

    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    private K key;
    private V value;
}
</pre></div>
<strong>Answer</strong>:
<div class="codeblock"><pre>public class Pair {

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey()   { return key; }
    public Object getValue() { return value; }

    public void setKey(Object key)     { this.key = key; }
    public void setValue(Object value) { this.value = value; }

    private Object key;
    private Object value;
}
</pre></div>
</li>
<li>What is the following method converted to after type erasure?
<div class="codeblock"><pre>public static &lt;T extends Comparable&lt;T&gt;&gt;
    int findFirstGreaterThan(T[] at, T elem) {
    // ...
}
</pre></div>
<strong>Answer</strong>:
<div class="codeblock"><pre>public static int findFirstGreaterThan(Comparable[] at, Comparable elem) {
    // ...
    }
</pre></div>
</li>
<li>Will the following method compile? If not, why?
<div class="codeblock"><pre>public static void print(List&lt;? extends Number&gt; list) {
    for (Number n : list)
        System.out.print(n + " ");
    System.out.println();
}
</pre></div>
<strong>Answer</strong>: Yes.
<br><br>
</li>
<li>Write a generic method to find the maximal element in the range <tt>[begin, end)</tt> of a list.<br><br>
<strong>Answer</strong>:
<div class="codeblock"><pre>import java.util.*;

public final class Algorithm {
    public static &lt;T extends Object &amp; Comparable&lt;? super T&gt;&gt;
        T max(List&lt;? extends T&gt; list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin &lt; end; ++begin)
            if (maxElem.compareTo(list.get(begin)) &lt; 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}
</pre></div>
</li>
<li>Will the following class compile?  If not, why?
<div class="codeblock"><pre>public class Singleton&lt;T&gt; {

    public static T getInstance() {
        if (instance == null)
            instance = new Singleton&lt;T&gt;();

        return instance;
    }

    private static T instance = null;
}
</pre></div>
<strong>Answer</strong>: No.  You cannot create a static field of the type parameter <tt>T</tt>.
<br><br>
</li>
<li> Given the following classes:
<div class="codeblock"><pre>class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node&lt;T&gt; { /* ... */ }
</pre></div>
Will the following code compile? If not, why?
<div class="codeblock"><pre>Node&lt;Circle&gt; nc = new Node&lt;&gt;();
Node&lt;Shape&gt;  ns = nc;
</pre></div>
<strong>Answer</strong>: No. Because <tt>Node&lt;Circle&gt;</tt> is not a subtype of <tt>Node&lt;Shape&gt;</tt>.
<br><br>
</li>
<li>Consider this class:
<div class="codeblock"><pre>class Node&lt;T&gt; implements Comparable&lt;T&gt; {
    public int compareTo(T obj) { /* ... */ }
    // ...
}
</pre></div>
Will the following code compile? If not, why?<br><br>
<strong>Answer</strong>: Yes.
<div class="codeblock"><pre>Node&lt;String&gt; node = new Node&lt;&gt;();
Comparable&lt;String&gt; comp = node;
</pre></div>
</li>
<li>How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
<div class="codeblock"><pre>public static &lt;T&gt;
    int findFirst(List&lt;T&gt; list, int begin, int end, UnaryPredicate&lt;T&gt; p)
</pre></div>
Note that two integers <em>a</em> and <em>b</em> are relatively prime if gcd(<em>a, b</em>) = 1, where gcd is short for greatest common divisor.<br><br>
<strong>Answer</strong>:
<div class="codeblock"><pre>import java.util.*;

public final class Algorithm {

    public static &lt;T&gt;
        int findFirst(List&lt;T&gt; list, int begin, int end, UnaryPredicate&lt;T&gt; p) {

        for (; begin &lt; end; ++begin)
            if (p.test(list.get(begin)))
                return begin;
        return -1;
    }

    // x &gt; 0 and y &gt; 0
    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) { }
            return y;
    }
}
</pre></div>
The generic <tt>UnaryPredicate</tt> interface is defined as follows:
<div class="codeblock"><pre>public interface UnaryPredicate&lt;T&gt; {
    public boolean test(T obj);
}
</pre></div>
The following program tests the <tt>findFirst</tt> method:
<div class="codeblock"><pre>import java.util.*;

class RelativelyPrimePredicate implements UnaryPredicate&lt;Integer&gt; {
    public RelativelyPrimePredicate(Collection&lt;Integer&gt; c) {
        this.c = c;
    }

    public boolean test(Integer x) {
        for (Integer i : c)
            if (Algorithm.gcd(x, i) != 1)
                return false;

        return c.size() &gt; 0;
    }

    private Collection&lt;Integer&gt; c;
}

public class Test {
    public static void main(String[] args) throws Exception {

        List&lt;Integer&gt; li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection&lt;Integer&gt; c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate&lt;Integer&gt; p = new RelativelyPrimePredicate(c);

        int i = ALgorithm.findFirst(li, 0, li.size(), p);

        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }
    }
}
</pre></div>
The program prints:
<div class="codeblock"><pre>11 is relatively prime to 7 18 19 25
</pre></div>
</li>
</ol>

</div>
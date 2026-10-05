package fibonacci;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        // Step 1: Use recursion method to find 45 sequence Fibonacci 
        generateFibonacciRecursion(45, fibonacciList);
        // Step 2: Display to screen
        displayFibonacci(fibonacciList);
    }

    private static int generateFibonacciRecursion(int n, ArrayList<Integer> arr) {

        // 1. Chỗ bạn còn thiếu: Khởi tạo mảng có đủ n + 1 phần tử (giá trị tạm thời là null)
        if (arr.isEmpty()) {
            for (int i = 0; i <= n; i++) {
                arr.add(null);
            }
        }

        // 2. Chỗ bạn còn thiếu: Kiểm tra nếu số thứ n đã tính rồi thì lấy luôn, không tính lại
        if (arr.get(n) != null) {
            return arr.get(n);
        }

        if (n == 0) {
            arr.set(0, 0); // Sửa add(0, 0) thành set(0, 0) để cập nhật đúng vị trí
            return 0;
        } else if (n == 1) {
            arr.set(1, 1); // Sửa add(1, 1) thành set(1, 1)
            return 1;
        } else {
            int sum = generateFibonacciRecursion(n - 1, arr) + generateFibonacciRecursion(n - 2, arr);
            arr.set(n, sum); // Sửa add(n, sum) thành set(n, sum)
            return sum;
        }

    }
    
    public static void displayFibonacci(ArrayList<Integer> array) {
        System.out.println("The " + array.size() + " sequence of Fibonacci:");
        // Loop through each element of array, print then add ","
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i < array.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
        System.out.println("\n--- Phần Test Phép Cộng ---");
        System.out.println("Number 1 is 0");
        System.out.println("Number 2 is 1");
        for (int i = 2; i < array.size(); i++) {
            int a = array.get(i - 2);
            int b = array.get(i - 1);
            int sum = a + b;
            System.out.println("Number " + (i + 1) + " is " + a + " + " + b + " = " + sum);
        }
    }

}

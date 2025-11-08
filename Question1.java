import java.util.Scanner;

public class Question1 {

    // Основная функция сортировки
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;  // Если массив из одного элемента, он уже отсортирован
        }

        // Разделяем массив на две части
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Рекурсивно сортируем обе части
        left = mergeSort(left);
        right = mergeSort(right);

        // Объединяем отсортированные части
        return merge(left, right);
    }

    // Слияние двух отсортированных массивов
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Сливаем два массива
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Добавляем оставшиеся элементы
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Сортировка массива
        int[] sortedArr = mergeSort(arr);

        // Вывод отсортированного массива
        System.out.print("Отсортированный массив: ");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

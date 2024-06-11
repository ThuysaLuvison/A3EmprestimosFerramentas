package modelo;

import com.google.protobuf.TextFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Util fornece métodos utilitários para manipulação de datas e
 * formatação de strings.
 */
public class Util {

    /**
     * Método para obter a data atual no formato SQL
     *
     * @return - A data atual no formato SQL.
     */
    public static Date dataAtual() {
        LocalDate hoje = LocalDate.now();
        /**
         * Obtém a data atual.
         */
        return Date.valueOf(hoje);

    }

    /**
     * Método para converter uma string para um objeto Date no formato SQL.
     *
     * @param dataString - A string que representa a data a ser convertida.
     * @return - Um objeto Date no formato SQL.
     * @throws com.google.protobuf.TextFormat.ParseException - Se houver erro na
     * conversão do formato do texto.
     * @throws java.text.ParseException - Se houver erro na análise da string de
     * data.
     */
    public static Date stringParaDateSQL(String dataString) throws TextFormat.ParseException, java.text.ParseException {
        /**
         * Define o formato da data.
         */
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * Converte a string para um objeto Date do Java.
         */
        java.util.Date dataUtil = formato.parse(dataString);
        /**
         * Retorna a data no formato SQL.
         */
        return new Date(dataUtil.getTime());

    }

    /**
     * Método para formatar um número de telefone.
     *
     * @param numero - O número de telefone a ser formatado.
     * @return - O número de telefone formatado, ou a string original se o
     * formato não corresponder.
     */
    public static String formatarNumero(String numero) {
        /**
         * Define o padrão do número de telefone.
         */
        Pattern pattern = Pattern.compile("(\\d{2})(\\d{5})(\\d{4})");

        /**
         * Cria um objeto Matcher para encontrar padrões na string.
         */
        Matcher matcher = pattern.matcher(numero);

        /**
         * Se o padrão for encontrado na string.
         */
        if (matcher.matches()) {

            /**
             * Formata o número de telefone.
             */
            String numeroFormatado = "(" + matcher.group(1) + ")" + matcher.group(2) + "-" + matcher.group(3);

            /**
             * Retorna o número de telefone formatado.
             */
            return numeroFormatado;

            /**
             * Se o padrão não for encontrado na string.
             */
        } else {

            /**
             * Retorna a string original.
             */
            return numero;

        }
    }
}

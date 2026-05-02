import excecoes.ItemNaoDisponivelException;
import excecoes.ItemNaoEncontradoException;
import excecoes.OperacaoInvalidaException;
import excecoes.SistemaFinalizadoException;
import servicos.CLIService;

class Main {
    public static void main(String[] args) {
        CLIService cliService = new CLIService();
        boolean sistemaExecutando = true;

        while (sistemaExecutando) {
            try {
                cliService.exibirMenu();
                cliService.navegar();

            } catch (OperacaoInvalidaException |
                     ItemNaoEncontradoException |
                     ItemNaoDisponivelException e) {

                System.out.println(e.getMessage());

            } catch (SistemaFinalizadoException e) {
                System.out.println(e.getMessage());
                sistemaExecutando = false;
            }
        }
    }
}
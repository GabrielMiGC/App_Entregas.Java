package AppEntregas;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class Main {
		public static void main(String[] Args) {
			Display display  = new Display();
			
			/* Esse bloco define as proporções do ícone da janela, sendo "pequena"
			 * utilizado na maior parte do tempo (durante a execução do programa)
			 * e "grande" quando o usuário utilzar o comando Alt + Tab.
			 */
			Image pequena = new Image(display,16,16);
			GC gc = new GC(pequena);
			gc.setBackground(display.getSystemColor(SWT.COLOR_DARK_RED));
			gc.fillGradientRectangle(0, 0, 16, 16, false);
			gc.dispose();
			
			Image grande = new Image(display, 32, 32);
			gc = new GC(grande);
			gc.setBackground(display.getSystemColor(SWT.COLOR_DARK_RED));
			gc.fillGradientRectangle(0, 0, 32, 32, false);
			gc.dispose();
			
			/*	Bloco destinado à implementação do shell,
			 * 	declarando a proporção da tela, tamanho do ícone.
			 */
			final Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX | SWT.RESIZE);
			shell.setText("Doofi - App de Entregas");
			shell.setSize(400,400);
			shell.setImages(new Image[] {pequena, grande});
			shell.setImage(pequena);
			shell.addListener(SWT.Close, new Listener(){
				public void handleEventFechar(Event event){
					int estilo = SWT.APPLICATION_MODAL| SWT.YES | SWT.NO;
					MessageBox caixaMensagem = new MessageBox(shell, estilo);
					caixaMensagem.setText("Aviso");
					caixaMensagem.setMessage("Deseja fechar o app?");
					event.doit = caixaMensagem.open() == SWT.YES;
				}

				@Override
				public void handleEvent(Event event) {
					// TODO Auto-generated method stub
					
				}
				
			});
			/* Exibir janela no centro da tela ao abrir o programa*/
			Monitor monitor = display.getPrimaryMonitor();
			Rectangle limite = monitor.getBounds();
			Rectangle rect = shell.getBounds();
			
			int x = limite.x + (limite.width - rect.width)/2;
			int y = limite.y + (limite.height - rect.height);
			
			shell.setLocation(x,y);
			shell.open();
			
			while(!shell.isDisposed()) {
				if(!display.readAndDispatch()) {
					display.sleep();
				}
			}
			display.dispose();
			
			//Button botao = new Button(,SWT.PUSH);
		}
}

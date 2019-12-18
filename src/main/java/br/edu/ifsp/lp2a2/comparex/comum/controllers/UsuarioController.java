package br.edu.ifsp.lp2a2.comparex.comum.controllers;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Usuario;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.UsuariosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    private UsuariosRepository usuarioRepository;

    public UsuarioController(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //    @GetMapping("/usuarios")
//    public ModelAndView listar(@Valid Usuario usuario) {
//        ModelAndView mv = new ModelAndView("comum/listarUsuario");
//        mv.addObject("usuarios", usuarioRepository.findAll());
//        usuarioRepository.save(usuario);
//        return mv;
//    }
//
//    @PostMapping("/usuarios/config")
//    public ModelAndView listarAlterar(@Valid Usuario usuario) {
//        ModelAndView mv = new ModelAndView("comum/listarUsuario");
//        mv.addObject("usuarios", usuarioRepository.findAll());
//        usuarioRepository.save(usuario);
//        return mv;
//    }

//
    /**permite usuario a buscar seus dados e poder editar ou apagar **/
    @GetMapping("/usuarios/config")
    public String configuracao(Usuario usuario) {
        return "comum/usuariobusca";
    }

    /**direciona para pagina de criar usuario**/
    @GetMapping("/usuarios/create")
    public String create(Usuario usuario) {
        return "comum/criarUsuario";
    }

    @PostMapping("/usuarios/{id}")
    public ModelAndView editar(@PathVariable int id, @Valid Usuario usuario, BindingResult result) {
        ModelAndView mv = new ModelAndView("comum/listarUsuario");
        if (result.hasErrors()) {
            mv = new ModelAndView("comum/editarUsuario");
            return mv;
        } else
            usuarioRepository.save(usuario);
        mv.addObject("usuarios", usuarioRepository.findUserById(id));

        return mv;
    }
/**botão tabela editar **/
    @GetMapping("/usuarios/{id}/edit")
    public ModelAndView edita(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("comum/editarUsuario");
        Usuario usuario = usuarioRepository.findUserById(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    /**ação salvar usuario novo **/
    @PostMapping("/usuarios/salvar")
    public String Cadastrar(@Valid Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            //mv = new ModelAndView("comum/criarUsuario");
            return "comum/criarUsuario";
        }
        String email = usuario.getEmail();
        String nome = usuario.getNome();
        int usuario2 = usuarioRepository.findByUserRepeticao(nome, email);

        if (usuario2 >= 1) {
            //   mv.addObject("alert", usuario);
            ResourceNotFoundException("Já existe usuário cadastrado para os mesmo dados!");
            return "comum/criarUsuario";
        } else {
            usuarioRepository.save(usuario);
            int id = usuario.getId();
            model.addAttribute("usuarios", usuarioRepository.findUserById(id));
            return "comum/listarUsuario";
        }
    }

    /**ação das configurações de usuario **/
    @PostMapping("/usuarios/alterar/login")
    public String AlterarLogin(@Valid Usuario usuario, Model model) {

        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();

        Usuario usu;
         usu = usuarioRepository.findByTodos(email, senha, nome);

        if (!usu.equals(null)) {
            int id = usu.getId();
            model.addAttribute("usuarios", usuarioRepository.findUserById(id));
            return "comum/listarUsuario";
        }
        else
            return "comum/index";
    }

    private String ResourceNotFoundException(String mensagem) {
        return mensagem;
    }

//
//    @GetMapping("/login/usu")
//    public String login() {
//        return "login";
//    }

    @PostMapping("/login")
    public ModelAndView logar( String email, String senha, HttpSession session) {
        ModelAndView mv = new ModelAndView("comum/resultado");
        Usuario usuario = usuarioRepository.findByUser(email, senha);

        //if (email.compareTo(usuario.getEmail()) == 0 && senha.compareTo(usuario.getSenha()) == 0) {
        if (usuario == null) {
            mv = new ModelAndView("comum/index");
            return mv;
        }
        else
       return  mv;
    }

    @GetMapping("/usuarios/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("comum/listarUsuario");
        Usuario usuario = usuarioRepository.findUserById(id);
        usuarioRepository.delete(usuario);
        mv.addObject("usuario", usuarioRepository.findUserById(id));
        return mv;
    }
}

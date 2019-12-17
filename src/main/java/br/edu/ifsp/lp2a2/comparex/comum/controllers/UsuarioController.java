package br.edu.ifsp.lp2a2.comparex.comum.controllers;

import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Usuario;
import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.UsuariosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

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

    @GetMapping("/usuarios/create")
    public String create(Usuario usuario) {
        return "comum/criarUsuario";
    }

    @PostMapping("/usuarios/xxxx")
    @Validated
    public ModelAndView create(@Valid Usuario usuario, BindingResult result) {
        ModelAndView mv = new ModelAndView("comum/index");
        if (result.hasErrors()) {
            mv = new ModelAndView("comum/criarUsuario");
            return mv;
        } else
            mv.addObject("usuarios", usuarioRepository.findAll());
        mv = new ModelAndView("comum/index");
        usuarioRepository.save(usuario);
        return mv;
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

    @GetMapping("/usuarios/{id}/edit")
    public ModelAndView edita(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("comum/editarUsuario");
        Usuario usuario = usuarioRepository.findUserById(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @PostMapping("/usuarios/salvar")
    public ModelAndView Cadastrar(@Valid Usuario usuario, BindingResult result) {
        ModelAndView mv = new ModelAndView("comum/listarUsuario");
        if (result.hasErrors()) {
            mv = new ModelAndView("comum/criarUsuario");
            return mv;
        } else {
            usuarioRepository.save(usuario);
            int id = usuario.getId();
            mv.addObject("usuarios", usuarioRepository.findUserById(id));
            return mv;
        }
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//
//    }

//    @PostMapping("/login")
//    public ModelAndView logar(@RequestParam("login") String login, @RequestParam("senha") String senha,  HttpSession session) {
//        ModelAndView mv = new ModelAndView("comum/index");
//
//        Usuario usuario = usuarioRepository.findByUser(login, senha);
//            if (login.compareTo(usuario.getEmail()) == 0 && senha.compareTo(usuario.getSenha()) == 0) {
//                mv.addObject("usuarios", usuarioRepository.findAll());
//                session.setAttribute("login", usuario.getId());
//            }
//        return mv;
//    }
//}
//
//    @GetMapping("/usuarios/{id}/delete")
//    public String delete(@PathVariable int id) {
//        ModelAndView mv = new ModelAndView("comum/listarUsuario");
//        Usuario usuario = usuarioRepository.findUserById(id);
//        //   .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
//
//        usuarioRepository.delete(usuario);
//
//        mv.addObject("usuarios", usuarioRepository.findById());
//
//        return "usuarios/list";
//    }
    @GetMapping("/usuarios/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("comum/listarUsuario");

        Usuario usuario = usuarioRepository.findUserById(id);
        usuarioRepository.delete(usuario);

        mv.addObject("usuario", usuarioRepository.findUserById(id));

        return mv;
    }
}
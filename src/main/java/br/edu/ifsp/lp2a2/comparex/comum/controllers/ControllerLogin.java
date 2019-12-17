//package br.edu.ifsp.lp2a2.comparex.comum.controllers;
//import br.edu.ifsp.lp2a2.comparex.comum.model.entidades.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/acesso")
//public class ControllerLogin {
//
//    private UsuarioRepository usuarioRepository;
//
//    @GetMapping("")
//    public ModelAndView loginUsu(Usuario usario) {
//        ModelAndView mv = new ModelAndView("comum/index");
//        mv.addObject("usuario", usuarioRepository.findAll());
//
//
//        return mv;
//    }
//
//    @PostMapping("/logar")
//    public void logar(Usuario usario) throws Exception {
//        List<Usuario> usu2 =      usuarioRepository.loginUsuario(usario.getNome());
//        if(usu2.size() >0){
//
//        }
//        else
//            throw new Exception("Usuario invalido");
//
//
//
//    }
//}

package jp.ac.ohara.E.seisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.model.SeisekiHyou;
import jp.ac.ohara.E.seisaku.model.SyusekiHyou;
import jp.ac.ohara.E.seisaku.service.GakuseiService;
import jp.ac.ohara.E.seisaku.service.SeisekiService;
import jp.ac.ohara.E.seisaku.service.SyusekiService;

@Controller
public class MainController {
	@Autowired
	private GakuseiService gakuseiService;
	@Autowired
	private SyusekiService syusekiService;

	

	
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "top";
  }
  
  @GetMapping("/add/")
  public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model)  {
      model.addObject("gakuseihyou", gakuseihyou);
  
  model.setViewName("form");
  return model;
  
          
    }
  
  
  @GetMapping("/shusseki/")
  public ModelAndView shusseki(SyusekiHyou syusekihyou, ModelAndView model)  {
      model.addObject("syusekihyou", syusekihyou);
  
  model.setViewName("shusseki");
  return model;
  }
  
       

  
	//("")の中はlocalhost:8080の後に続くURLを記述　(localhost:8080/sekiseki/に表示させたいので"/seiseki/")
	@GetMapping("/seiseki/")
	//そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
	  public ModelAndView add(SeisekiHyou seisekihyou, ModelAndView model) {
	      model.addObject("seisekihyou", seisekihyou);
	      // ()の中にアクセスしたいHTMLファイルの.htmlを省いたファイルの名前を記述
	      model.setViewName("seisekitouroku");
	      return model;
}
	@Autowired
	private SeisekiService seisekiService;
	
	//Form送信
	@PostMapping("/add/")
	  public String gakuseihyou(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result, ModelAndView model,
	          RedirectAttributes redirectAttributes) {
	      try {
	          this.gakuseiService.save(gakuseihyou);
	          redirectAttributes.addFlashAttribute("exception", "");

	      } catch (Exception e) {
	          redirectAttributes.addFlashAttribute("exception", e.getMessage());
	      }
	      return "redirect:/";

	    }
	
	


	@PostMapping("/seiseki/")
	public String seisekihyou(@Validated @ModelAttribute @NonNull SeisekiHyou seisekihyou, RedirectAttributes result, ModelAndView model,
	        RedirectAttributes redirectAttributes) {
	    try {
	        this.seisekiService.save(seisekihyou);
	        redirectAttributes.addFlashAttribute("exception", "");
	
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("exception", e.getMessage());
	    }
	    return "redirect:/";
	
	  }
	


	//Form送信
		@PostMapping("/shusseki/")
		  public String syusekihyou(@Validated @ModelAttribute @NonNull SyusekiHyou syusekihyou, RedirectAttributes result, ModelAndView model,
		          RedirectAttributes redirectAttributes) {
		      try {
		          this.syusekiService.save(syusekihyou);
		          redirectAttributes.addFlashAttribute("exception", "");

		      } catch (Exception e) {
		          redirectAttributes.addFlashAttribute("exception", e.getMessage());
		      }
		      return "redirect:/";

		    }


		//("")の中はlocalhost:8080の後に続くURLを記述　(localhost:8080/sekiseki/に表示させたいので"/seiseki/")
		@GetMapping("/itiran/")
		//そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
		  public String add(Model model) {
			System.out.println(gakuseiService.getGakuseiList().toString());
		      model.addAttribute("gakuseiList", gakuseiService.getGakuseiList());
		      return "gakuseiitiran";
	}

		@GetMapping("/seisekiitiran/")
		//そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
		  public String seiseki(Model model) {
			System.out.println(seisekiService.getSeisekiList().toString());
		      model.addAttribute("seisekiList", seisekiService.getSeisekiList());
		      return "seisekiitiran";
	}
		
}
package org.eclipse.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.EmploiDuTemps;


/**
 * Servlet implementation class EmploiDuTempsServlet
 */
@WebServlet("/emploi")
public class EmploiDuTempsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploiDuTempsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EmploiDuTemps emploi = new EmploiDuTemps();
		String [][] tabEmploi;
		int jour = Integer.parseInt(request.getParameter("jour"));
		int heureDebut = Integer.parseInt(request.getParameter("heureDebut"));
		int heureFin = Integer.parseInt(request.getParameter("heureFin"));
		String matiere = request.getParameter("matiere");
		
		try {
			FileInputStream fis = new FileInputStream("c:\\test\\emploidutemps.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			emploi = (EmploiDuTemps) ois.readObject();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		tabEmploi = emploi.getTabEmploi();
		if (heureDebut <= heureFin)
			for (int i = heureDebut; i <= heureFin; i++)
				tabEmploi[i][jour] = matiere;
		
		try {
			FileOutputStream fs = new FileOutputStream("c:\\test\\emploidutemps.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(emploi);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("tableau", tabEmploi);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

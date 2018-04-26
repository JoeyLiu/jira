/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

/**
 *
 * @author damaomao
 */
public interface IRequest {
   // public void Build();
    public String Send(String issue, String AO, String cookie);
    public String Parser(String reponse);
}

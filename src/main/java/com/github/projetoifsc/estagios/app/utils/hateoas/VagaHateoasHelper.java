package com.github.projetoifsc.estagios.app.utils.hateoas;

import com.github.projetoifsc.estagios.app.controller.vagas.VagasController;

public class VagaHateoasHelper {

    private static Class<VagasController> vagaController = VagasController.class;

//    public static void addPublicProfileLinks(VagaBasicView vaga) {
//
//        vaga.add(linkTo(methodOn(vagaController)
//                .getPublicProfile(vaga.getId())).withSelfRel());
//        vaga.add(linkTo(methodOn(OrgController.class)
//                .getUserPublicProfile(vaga.getOwner().getId())).withRel("criador"));
//
//    }
//
//
//    public static void addPrivateProfileLinks(VagaBasicView vaga) {
//
//        vaga.add(linkTo(methodOn(vagaController)
//                .getPrivateProfile(vaga.getId())).withSelfRel()
//                .andAffordance(afford(methodOn(vagaController
//                )
//                        .create(new NewVagaRequest())))
//                .andAffordance(afford(methodOn(vagaController)
//                        .update(vaga.getId(), new NewVagaRequest())))
//                .andAffordance(afford(methodOn(vagaController)
//                        .delete(vaga.getId())))
//        );
//        vaga.add(linkTo(methodOn(OrgController.class)
//                .getAuthUserPerfil(vaga.getOwner().getId())).withRel("criador"));
//      //  vaga.add(linkTo(methodOn(vagaController)
//      //          .getVagaRecipients(vaga.getId())).withRel("destinatarios"));
//
//
//    }


}

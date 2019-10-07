import { es, enGB, fr, ptBR } from "date-fns/locale";

export const BASE_URL = "192.168.0.106";
export const eng = {
  addComment: "Add Comment",
  addReceipt: "Add Receipt",
  search: "Search",
  add: "Add",
  cancel: "Cancel",
  noCommentAdded: "No Comment Added",
  successfulUpdate: "Successfully Updated",
  unsuccessfulUpdate: "Usuccessfully Updated",
  unableToFetch: "Unable to Fetch Data From The API",
  selectedLanguage: "Selected Language:"
};
export const esp = {
  addComment: "Agrega Comentario",
  addReceipt: "Agrega Recite",
  search: "Búsqueda",
  add: "Agrega",
  cancel: "Cancela",
  noCommentAdded: "Ningun Comentario Agregado",
  successfulUpdate: "Actualizado con Exito",
  unsuccessfulUpdate: "Actualizado sin Exito",
  unableToFetch: "No se Puede sacar datos del API",
  selectedLanguage: "Idioma Selecionada: "
};

export const fra = {
  addComment: " Ajouter un Commentaire",
  addReceipt: "Ajouter un Reçu",
  search: "Rechercher",
  add: "Ajouter",
  cancel: "Annuler",
  noCommentAdded: "Aucun Commentaire Ajouté",
  successfulUpdate: "Mise à Jour Réussie",
  unsuccessfulUpdate: "Mise à Jour Sans Succès",
  unableToFetch: "Impossible de Récupérer Les Données du API",
  selectedLanguage: "Langue Choisie: "
};

export const por = {
  addComment: "Adicionar Comentário",
  addReceipt: "Adicionar Recibo",
  search: "Pesquisa",
  add: "Adiciona",
  cancel: "Cancelar",
  noCommentAdded: "Nenhum comentário adicionado",
  successfulUpdate: "Atualizado com Sucesso",
  unsuccessfulUpdate: "Atualizado sem Sucesso",
  unableToFetch: "Não Foi Possível Buscar Dados do API",
  selectedLanguage: "Idioma Selecionado"
};

export const localeMap = {
  eng: enGB,
  fra: fr,
  esp: es,
  por: ptBR
};
